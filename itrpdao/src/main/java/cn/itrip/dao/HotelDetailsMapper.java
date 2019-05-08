package cn.itrip.dao;
import cn.itrip.dao.pojo.*;
import cn.itrip.pojo.*;
import cn.itrip.pojo.ItripHotel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface HotelDetailsMapper {

    List<ItripLabelDic> queryhotelroombed();

    List<Integer> queryhotelroombyhotel(QueryHotelRoomByHotel queryHotelRoomByHotel);

    Long selectStore(Long roomId, Date checkInDate, Date checkOutDate);

    Long selectRealStore(Long roomId);

    List<ItripHotelRoom> searchInformationByRommId(List<Long> ids);

    Long selectStoreExceptCount(@Param("roomId") Long roomId,@Param("startDate") Date checkInDate,@Param("endDate") Date checkOutDate);

    List<ItripImage> getImg(Long hotelId);

    ListExt getvideodesc(Long hotelId);

    ItripHotel queryhotelfacilities(Long hotelId);

    AvgScore gethotelscore(Long hotelId);

    CommentCount getcount(Long id);

    List<ItripAreaDic> queryhotcity(Long isChina);

    List<ItripLabelDic> queryhotelfeature();

    List<ItripAreaDic> querytradearea(Long id);

    List<ItripLabelDic> queryhoteldetails(Long hotelId);

    ItripLabelDic queryFinal(Long hotelId);

    Long selectStore(String roomId, String checkInDate, String checkOutDate);
}
