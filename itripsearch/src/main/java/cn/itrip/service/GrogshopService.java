package cn.itrip.service;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.HotelInfo;
import cn.itrip.pojo.ParametersOfTheClass;

public interface GrogshopService {

    Dto searchItripHotelListByHotCity(ParametersOfTheClass parametersOfTheClass);

    Dto searchItripHotelPage(HotelInfo hotelInfo);
}
