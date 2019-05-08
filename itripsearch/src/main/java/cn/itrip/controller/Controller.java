package cn.itrip.controller;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.HotelInfo;
import cn.itrip.pojo.ParametersOfTheClass;
import cn.itrip.service.GrogshopService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/hotellist/")
public class Controller {

    @Resource
    private GrogshopService grogshopService;

    @RequestMapping("searchItripHotelListByHotCity")
    public Dto searchItripHotelListByHotCity(@RequestBody ParametersOfTheClass parametersOfTheClass){
        return grogshopService.searchItripHotelListByHotCity(parametersOfTheClass);
    }

    @RequestMapping(value = "searchItripHotelPage",method = RequestMethod.POST)
    public Dto searchItripHotelPage(@RequestBody HotelInfo hotelInfo){
        return grogshopService.searchItripHotelPage(hotelInfo);
    }


}
