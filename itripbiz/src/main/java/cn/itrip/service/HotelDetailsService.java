package cn.itrip.service;
import cn.itrip.dao.pojo.QueryHotelRoomByHotel;
import cn.itrip.dto.Dto;
public interface HotelDetailsService {

    Dto queryhotelroombed();

    Dto queryhotelroombyhotel(QueryHotelRoomByHotel queryHotelRoomByHotel);

    Dto queryhotelpolicy(Long hoetlId);

    Dto getImg(Long hotelId);

    Dto queryhotelfacilities(Long hotelId);

    Dto gethotelscore(Long hotelId);

    Dto getcount(Long id);

    Dto queryhotcity(Long isChina);

    Dto queryhotelfeature();

    Dto querytradearea(Long id);

    Dto getvideodesc(Long hotelId);

    Dto queryhoteldetails(Long hotelId);
}
