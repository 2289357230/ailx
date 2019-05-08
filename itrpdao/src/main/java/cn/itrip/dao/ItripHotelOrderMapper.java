package cn.itrip.dao;
import cn.itrip.dao.pojo.ItripHotel;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripUserLinkUser;

import java.util.List;

public interface ItripHotelOrderMapper {

    List<ItripHotelOrder> queryAll(ItripHotel itripHotel);

    List<ItripUserLinkUser> queryuserlinkuser(ItripHotel itripHotel);

    boolean adduserlinkuser(ItripUserLinkUser itripUserLinkUser);

    boolean deluserlinkuser(Long[] ids);

    boolean modifyuserlinkuser(ItripUserLinkUser itripUserLinkUser);

}
