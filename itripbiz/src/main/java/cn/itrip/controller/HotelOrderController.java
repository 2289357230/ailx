package cn.itrip.controller;
import cn.itrip.dao.pojo.AddHotelOrderParam;
import cn.itrip.dao.pojo.ReceiveOrderParam;
import cn.itrip.dto.Dto;
import cn.itrip.service.HotelOrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/api/hotelorder/")
public class HotelOrderController {

    @Resource
    private HotelOrderService hotelOrderService;

    @RequestMapping(value = "getpreorderinfo",method = RequestMethod.POST)
    public Dto getpreorderinfo(@RequestBody ReceiveOrderParam receiveOrderParam){
        return hotelOrderService.getpreorderinfo(receiveOrderParam);
    }

    @RequestMapping(value = "addhotelorder",method = RequestMethod.POST,headers = "token")
    public Dto addhotelorder(@RequestBody AddHotelOrderParam addHotelOrderParam, HttpServletRequest request){
        return hotelOrderService.addhotelorder(addHotelOrderParam,request.getHeader("token").split("-")[2]);
    }

    @RequestMapping(value = "queryOrderById/{orderId}",method = RequestMethod.GET)
    public Dto queryOrderById(@PathVariable Long orderId){
        return hotelOrderService.queryOrderById(orderId);
    }
}
