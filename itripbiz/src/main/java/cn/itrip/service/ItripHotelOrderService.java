package cn.itrip.service;
import cn.itrip.dao.pojo.ItripHotel;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripUserLinkUser;

import java.util.List;

public interface ItripHotelOrderService {

    List<ItripHotelOrder> queryAll(ItripHotel itripHotel);

    Dto queryuserlinkuser(ItripHotel itripHotel);

    Dto adduserlinkuser(ItripUserLinkUser itripUserLinkUser);

    Dto deluserlinkuser(Long[] ids);

    Dto modifyuserlinkuser(ItripUserLinkUser itripUserLinkUser);


}
