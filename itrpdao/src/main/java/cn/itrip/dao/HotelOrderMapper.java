package cn.itrip.dao;
import cn.itrip.dao.pojo.AddHotelOrderParam;
import cn.itrip.dao.pojo.PreoederInfo;
import cn.itrip.dao.pojo.ReceiveOrderParam;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripHotelRoom;

import java.util.List;

public interface HotelOrderMapper {
    PreoederInfo getpreorderinfo(ReceiveOrderParam receiveOrderParam);

    boolean addhotelorder(AddHotelOrderParam addHotelOrderParam);

    ItripHotelOrder selectOrderNo(String orderNo);

    ItripHotelRoom selectRoom(Long id);

    AddHotelOrderParam queryOrderById(Long orderId);

    List<ItripHotelOrder> ScanTheOrder();

    boolean updateTheOrderStatus(int count,Long orderId);

    boolean updateTheOrderStatusByOrderNo(int count,String orderNo);
}
