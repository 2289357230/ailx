package cn.itrip.service.impl;

import cn.itrip.dao.HotelDetailsMapper;
import cn.itrip.dao.pojo.AvgScore;
import cn.itrip.dao.pojo.CommentCount;
import cn.itrip.dao.pojo.ListExt;
import cn.itrip.dao.pojo.QueryHotelRoomByHotel;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.*;
import cn.itrip.service.HotelDetailsService;
import cn.itrip.utils.DtoUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelDetailsServiceImpl implements HotelDetailsService {

    @Resource
    private HotelDetailsMapper hotelDetailsMapper;

    @Override
    public Dto queryhotelroombed() {
        List<ItripLabelDic> queryhotelroombed = hotelDetailsMapper.queryhotelroombed();
        if(queryhotelroombed!=null){
            return DtoUtils.getSuccessWhitDataDto("获取成功",queryhotelroombed);
        }
        return DtoUtils.getErrorDto(null,"获取失败");
    }

    @Override
    public Dto queryhotelroombyhotel(QueryHotelRoomByHotel queryHotelRoomByHotel) {
        List<Integer> queryhotelroombyhotel = hotelDetailsMapper.queryhotelroombyhotel(queryHotelRoomByHotel);
        List<Long> longids=new ArrayList<>();
        for (Integer id:queryhotelroombyhotel){
            Long store = hotelDetailsMapper.selectStore(Long.valueOf(id), queryHotelRoomByHotel.getStartDate(), queryHotelRoomByHotel.getEndDate());
            if(store==0){
               store=hotelDetailsMapper.selectRealStore(Long.valueOf(id))-hotelDetailsMapper.selectStoreExceptCount(Long.valueOf(id),queryHotelRoomByHotel.getStartDate(),queryHotelRoomByHotel.getEndDate());
            }
            if (store!=0){
                longids.add(Long.valueOf(id));
            }
        }
        List<ItripHotelRoom> itripHotelRooms = hotelDetailsMapper.searchInformationByRommId(longids);
        List list=new ArrayList();
        for (ItripHotelRoom itrip:itripHotelRooms){
            List array=new ArrayList();
            array.add(itrip);
            list.add(array);
        }
        if(list.size()>0){
            return DtoUtils.getSuccessWhitDataDto("数据获取成功",list);
        }
        return DtoUtils.getFailDto(null,null);
    }

    @Override
    public Dto queryhotelpolicy(Long hoetlId) {
        ItripHotel queryhotelpolicy = hotelDetailsMapper.queryhotelfacilities(hoetlId);
        if(queryhotelpolicy!=null){
            return DtoUtils.getSuccessWhitDataDto(null,queryhotelpolicy.getHotelPolicy());
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto getImg(Long hotelId) {
        if (hotelId!=null&&hotelId>0){
            List<ItripImage> img = hotelDetailsMapper.getImg(hotelId);
            if(img!=null){
               return DtoUtils.getSuccessWhitDataDto("获取酒店图片房型成功",img);
            }
        }
        return DtoUtils.getErrorDto(null,"获取酒店图片房型失败");
    }

    @Override
    public Dto queryhotelfacilities(Long hotelId) {
        ItripHotel queryhotelfacilities = hotelDetailsMapper.queryhotelfacilities(hotelId);
        if (queryhotelfacilities!=null){
            return DtoUtils.getSuccessWhitDataDto(null,queryhotelfacilities.getFacilities());
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto gethotelscore(Long hotelId) {
        AvgScore gethotelscore = hotelDetailsMapper.gethotelscore(hotelId);
        if(gethotelscore!=null){
            return DtoUtils.getSuccessWhitDataDto(null,gethotelscore);
        }
        return DtoUtils.getSuccessWhitDataDto(null,new AvgScore());
    }

    @Override
    public Dto getcount(Long id) {
        CommentCount getcount = hotelDetailsMapper.getcount(id);
        if(getcount!=null){
            return DtoUtils.getSuccessWhitDataDto("获取酒店各类评论数成功",getcount);
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto queryhotcity(Long isChina) {
        if (isChina!=null){
            List<ItripAreaDic> queryhotcity = hotelDetailsMapper.queryhotcity(isChina);
            if (queryhotcity!=null&&queryhotcity.size()>0){
                return DtoUtils.getSuccessWhitDataDto(null,queryhotcity);
            }
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto queryhotelfeature() {
        List<ItripLabelDic> queryhotelfeature = hotelDetailsMapper.queryhotelfeature();
        if (queryhotelfeature!=null&&queryhotelfeature.size()>0){
            return DtoUtils.getSuccessWhitDataDto(null,queryhotelfeature);
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto querytradearea(Long id) {
        List<ItripAreaDic> querytradearea = hotelDetailsMapper.querytradearea(id);
        if (querytradearea!=null&&querytradearea.size()>0){
            return DtoUtils.getSuccessWhitDataDto(null,querytradearea);
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto getvideodesc(Long hotelId) {
        if (hotelId!=null&&hotelId>0){
            ListExt getvideodesc = hotelDetailsMapper.getvideodesc(hotelId);
            if(!ObjectUtils.isEmpty(getvideodesc)){
                return DtoUtils.getSuccessWhitDataDto(null,getvideodesc);
            }
        }
        return DtoUtils.getErrorDto(null,null);
    }

    @Override
    public Dto queryhoteldetails(Long hotelId) {
        if (hotelId!=null&&hotelId>0){
            List<ItripLabelDic> queryhoteldetails = hotelDetailsMapper.queryhoteldetails(hotelId);
            ItripLabelDic queryFinal = hotelDetailsMapper.queryFinal(hotelId);
            if(!ObjectUtils.isEmpty(queryhoteldetails)){
                queryFinal.setName("酒店介绍");
                queryhoteldetails.add(queryFinal);
                return DtoUtils.getSuccessWhitDataDto(null,queryhoteldetails);
            }
        }
        return DtoUtils.getErrorDto(null,null);
    }
}
