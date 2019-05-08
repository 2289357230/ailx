package cn.itrip.service;
import cn.itrip.dao.pojo.itripImages;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.CommentEntity;

public interface CommentService {

    Dto gettraveltype();

    Dto gethoteldesc(Long hotelId);

    Dto getimg(Long hotelId);

    Dto getpersonalorderinfo(Long id,Long token);

    Dto add(itripImages images,String token);

    Dto getpersonalorderroominfo(Long orderId,String toekn);

    Dto getcommentlist(CommentEntity commentEntity);

    Dto getImg(Long id);
}
