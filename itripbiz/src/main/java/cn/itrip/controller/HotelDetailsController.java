package cn.itrip.controller;
import cn.itrip.dao.pojo.QueryHotelRoomByHotel;
import cn.itrip.dto.Dto;
import cn.itrip.service.HotelDetailsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api/")
public class HotelDetailsController {

    @Resource
    private HotelDetailsService hotelDetailsService;

    @RequestMapping(value = "/hotelroom/queryhotelroombed",method = RequestMethod.GET)
    public Dto queryhotelroombed(){
        return hotelDetailsService.queryhotelroombed();
    }

    @RequestMapping(value = "hotelroom/queryhotelroombyhotel",method = RequestMethod.POST)
    public Dto queryhotelroombyhotel(@RequestBody QueryHotelRoomByHotel queryHotelRoomByHotel){
        return hotelDetailsService.queryhotelroombyhotel(queryHotelRoomByHotel);
    }

    @RequestMapping(value = "hotel/getvideodesc/{hoetlId}",method = RequestMethod.GET)
    public Dto getvideodesc(@PathVariable Long hoetlId){
        return hotelDetailsService.getvideodesc(hoetlId);
    }

    @RequestMapping(value = "hotelroom/getimg/{hoetlId}",method = RequestMethod.GET)
    public Dto getimg(@PathVariable Long hoetlId){
        return hotelDetailsService.getImg(hoetlId);
    }
    @RequestMapping(value = "comment/getcount/{hoetlId}",method = RequestMethod.GET)
    public Dto getcount(@PathVariable Long hoetlId){
        return hotelDetailsService.getcount(hoetlId);
    }

    @RequestMapping(value = "hotel/queryhotelpolicy/{hoetlId}",method = RequestMethod.GET)
    public Dto queryhotelpolicy(@PathVariable Long hoetlId){
        return hotelDetailsService.queryhotelpolicy(hoetlId);
    }

    @RequestMapping(value = "/hotel/queryhotelfacilities/{hoetlId}",method = RequestMethod.GET)
    public Dto queryhotelfacilities(@PathVariable Long hoetlId){
        return hotelDetailsService.queryhotelfacilities(hoetlId);
    }
    @RequestMapping(value = "comment/gethotelscore/{hoetlId}",method = RequestMethod.GET)
    public Dto gethotelscore(@PathVariable Long hoetlId){
        return hotelDetailsService.gethotelscore(hoetlId);
    }

    @RequestMapping(value = "hotel/queryhotcity/{isChina}",method = RequestMethod.GET)
    public Dto queryhotcity(@PathVariable Long isChina){
        return hotelDetailsService.queryhotcity(isChina);
    }

    @RequestMapping(value = "hotel/queryhotelfeature",method = RequestMethod.GET)
    public Dto queryhotelfeature(){
        return hotelDetailsService.queryhotelfeature();
    }

    @RequestMapping(value = "hotel/querytradearea/{id}",method = RequestMethod.GET)
    public Dto querytradearea(@PathVariable Long id){
        return  hotelDetailsService.querytradearea(id);
    }

    @RequestMapping(value = "hotel/queryhoteldetails/{hotelId}",method = RequestMethod.GET)
    public Dto queryhoteldetails(@PathVariable Long hotelId){
        return hotelDetailsService.queryhoteldetails(hotelId);
    }
}
