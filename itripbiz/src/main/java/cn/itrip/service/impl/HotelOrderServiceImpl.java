package cn.itrip.service.impl;

import cn.itrip.dao.HotelDetailsMapper;
import cn.itrip.dao.HotelOrderMapper;
import cn.itrip.dao.pojo.AddHotelOrderParam;
import cn.itrip.dao.pojo.PreoederInfo;
import cn.itrip.dao.pojo.ReceiveOrderParam;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripHotelRoom;
import cn.itrip.service.HotelOrderService;
import cn.itrip.utils.DtoUtils;
import cn.itrip.utils.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HotelOrderServiceImpl implements HotelOrderService {

    @Resource
    private HotelOrderMapper hotelOrderMapper;

    @Resource
    private HotelDetailsMapper hotelDetailsMapper;

    @Override
    public Dto getpreorderinfo(ReceiveOrderParam receiveOrderParam) {
        if (!ObjectUtils.isEmpty(receiveOrderParam)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Long store=0L;
            try {
                receiveOrderParam.setCheckInDate(simpleDateFormat.parse(simpleDateFormat.format(receiveOrderParam.getCheckInDate())));
                receiveOrderParam.setCheckOutDate(simpleDateFormat.parse(simpleDateFormat.format(receiveOrderParam.getCheckOutDate())));
                 store = hotelDetailsMapper.selectStore(receiveOrderParam.getRoomId(), receiveOrderParam.getCheckInDate(), receiveOrderParam.getCheckOutDate());
                if(store==0){
                    store=hotelDetailsMapper.selectRealStore(receiveOrderParam.getRoomId())-hotelDetailsMapper.selectStoreExceptCount(receiveOrderParam.getRoomId(),receiveOrderParam.getCheckInDate(),receiveOrderParam.getCheckOutDate());
                }else{
                    store=store-hotelDetailsMapper.selectStoreExceptCount(receiveOrderParam.getRoomId(),receiveOrderParam.getCheckInDate(),receiveOrderParam.getCheckOutDate());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            PreoederInfo getpreorderinfo = hotelOrderMapper.getpreorderinfo(receiveOrderParam);
            getpreorderinfo.setStore(store);
            if (!ObjectUtils.isEmpty(getpreorderinfo)) {
                return DtoUtils.getSuccessWhitDataDto("获取成功", getpreorderinfo);
            }
            return DtoUtils.getErrorDto(null, "获取失败(未查到数据)");
        }
        return DtoUtils.getErrorDto(null, "获取失败（参数获取失败）");
    }

    @Override
    public Dto addhotelorder(AddHotelOrderParam addHotelOrderParam, String token) {
        if (addHotelOrderParam != null) {
            addHotelOrderParam.setToken(token);
            addHotelOrderParam.setOrderNo(getUUID());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(addHotelOrderParam.getLinkUser().get(0).getLinkUserName());
            for (int i = 0; i < addHotelOrderParam.getLinkUser().size(); i++) {
                if (i >= 1) {
                    stringBuffer.append("," + addHotelOrderParam.getLinkUser().get(i).getLinkUserName());
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startDate = simpleDateFormat.parse(simpleDateFormat.format(addHotelOrderParam.getCheckInDate()));
                Date endDate = simpleDateFormat.parse(simpleDateFormat.format(addHotelOrderParam.getCheckOutDate()));
                addHotelOrderParam.setBookingDays(longOfTwoDate(startDate,endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            addHotelOrderParam.setLinkUserName(stringBuffer.toString());
            ItripHotelRoom itripHotelRoom = hotelOrderMapper.selectRoom(addHotelOrderParam.getRoomId());
            addHotelOrderParam.setPayAmount(itripHotelRoom.getRoomPrice()*addHotelOrderParam.getCount()*addHotelOrderParam.getBookingDays());
            boolean addhotelorder = hotelOrderMapper.addhotelorder(addHotelOrderParam);
            ItripHotelOrder itripHotelOrder = hotelOrderMapper.selectOrderNo(addHotelOrderParam.getOrderNo());
            addHotelOrderParam.setId(itripHotelOrder.getId());
            if (addhotelorder && itripHotelOrder != null) {
                return DtoUtils.getSuccessWhitDataDto(null, addHotelOrderParam);
            }
            return null;
        }
        return null;
    }

    @Override
    public Dto queryOrderById(Long orderId) {
        if (orderId!=null&&orderId>0){
            AddHotelOrderParam addHotelOrderParam = hotelOrderMapper.queryOrderById(orderId);
            if(addHotelOrderParam!=null){
                return DtoUtils.getSuccessWhitDataDto(null,addHotelOrderParam);
            }
        }
        return null;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    @Override
    public void ScanTheOrder() {
        List<ItripHotelOrder> itripHotelOrders = hotelOrderMapper.ScanTheOrder();
        for (ItripHotelOrder itrip:itripHotelOrders){
            try {
                if(getDatePoor(new Date(),itrip.getCreationDate())>=7200&&itrip.getOrderStatus()==0){
                   hotelOrderMapper.updateTheOrderStatus(1,itrip.getId());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public  Long getDatePoor(Date endDate, Date nowDate) throws ParseException {
        SimpleDateFormat str=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date end = str.parse(str.format(endDate));
        Date now = str.parse(str.format(nowDate));
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long diff = end.getTime() - now.getTime();
        long hour = diff % nd / nh;
        long min = diff % nd % nh / nm;
        long ss = diff / 1000;
        return ss;
    }


    public String getUUID() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(date);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        return "D-" +MD5.getMd5(time + String.format("%011d", hashCodeV), 30).toUpperCase();
    }

    public int longOfTwoDate(Date first, Date second) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);
        int cnt = 0;
        while (calendar.getTime().compareTo(second) != 0) {
            calendar.add(Calendar.DATE, 1);
            cnt++;
        }
        return cnt;
    }
}
