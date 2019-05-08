package cn.itrip.controller;
import cn.itrip.dao.pojo.itripImages;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.CommentEntity;
import cn.itrip.pojo.ItripImage;
import cn.itrip.service.CommentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "comment/gettraveltype",method = RequestMethod.GET)
    public Dto gettraveltype(){
        return commentService.gettraveltype();
    }

    @RequestMapping(value = "comment/gethoteldesc/{hotelId}",method = RequestMethod.GET)
    public Dto gethoteldesc(@PathVariable Long hotelId){
        return commentService.gethoteldesc(hotelId);
    }

    @RequestMapping(value = "hotel/getimg/{hotelId}",method = RequestMethod.GET)
    public Dto getimg(@PathVariable Long hotelId){
        return commentService.getimg(hotelId);
    }

    @RequestMapping(value = "hotelorder/getpersonalorderroominfo/{id}",method = RequestMethod.GET,headers = "token")
    public Dto getpersonalorderroominfo(@PathVariable("id") Long hotelId,HttpServletRequest request){
        return commentService.getpersonalorderroominfo(hotelId,request.getHeader("token"));
    }

    @RequestMapping(value = "comment/add",method = RequestMethod.POST,headers = "token")
    public Dto add(@RequestBody itripImages images,HttpServletRequest request){
        return commentService.add(images,request.getHeader("token").split("-")[2]);
    }

    @RequestMapping(value = "hotelorder/getpersonalorderinfo/{id}",method = RequestMethod.GET,headers = "token")
    public Dto getpersonalorderinfo(@PathVariable("id") Long id,HttpServletRequest request){
        return commentService.getpersonalorderinfo(id, Long.valueOf(request.getHeader("token").split("-")[2]));
    }

    @RequestMapping(value = "comment/getcommentlist",method = RequestMethod.POST)
    public Dto getcommentlist(@RequestBody CommentEntity commentEntity){
        return commentService.getcommentlist(commentEntity);
    }

    @RequestMapping(value = "comment/getimg/{commentId}",method = RequestMethod.GET)
    public Dto getImg(@PathVariable("commentId") Long id){
        return commentService.getImg(id);
    }
}
