package cn.itrip.service;
import cn.itrip.dao.pojo.AddHotelOrderParam;
import cn.itrip.dao.pojo.ReceiveOrderParam;
import cn.itrip.dto.Dto;

public interface HotelOrderService {

    Dto getpreorderinfo(ReceiveOrderParam receiveOrderParam);

    Dto addhotelorder(AddHotelOrderParam addHotelOrderParam,String token);

    Dto queryOrderById(Long orderId);

    void ScanTheOrder();
}
