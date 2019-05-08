package cn.itrip.service.impl;
import cn.itrip.dao.CommentMapper;
import cn.itrip.dao.HotelOrderMapper;
import cn.itrip.dao.pojo.OrderDetails;
import cn.itrip.dao.pojo.Page;
import cn.itrip.dao.pojo.hotelFeatureList;
import cn.itrip.dao.pojo.itripImages;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.CommentEntity;
import cn.itrip.pojo.CommentTableDic;
import cn.itrip.service.CommentService;
import cn.itrip.utils.DtoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private HotelOrderMapper hotelOrderMapper;

    @Override
    public Dto gettraveltype() {
        List<hotelFeatureList> gettraveltype = commentMapper.gettraveltype();
        if (gettraveltype!=null&&gettraveltype.size()>0) {
            return DtoUtils.getSuccessWhitDataDto("获取旅游类型列表成功",gettraveltype);
        }
        return DtoUtils.getFailDto("000000","获取旅游类型列表失败");
    }

    @Override
    public Dto gethoteldesc(Long hotelId) {
        if(hotelId>0&&hotelId!=null) {
            return DtoUtils.getSuccessWhitDataDto(null,commentMapper.gethoteldesc(hotelId));
        }
        return DtoUtils.getFailDto(null,null);
    }

    @Override
    public Dto getimg(Long hotelId) {
        if(hotelId>0&&hotelId!=null) {
            return DtoUtils.getSuccessWhitDataDto(null,commentMapper.getimg(hotelId));
        }
        return DtoUtils.getFailDto(null,null);
    }

    @Override
    public Dto getpersonalorderinfo(Long id,Long token) {
        if (id>0&&token>0){
            return DtoUtils.getSuccessWhitDataDto("获取相关房型订单信息成功",commentMapper.getpersonalorderinfo(id,token));
        }
        return DtoUtils.getFailDto(null,"没有相关房型订单信息");
    }

    @Override
    public Dto add(itripImages images,String token) {
        if(images!=null){
            images.setToken(token);
            images.setId((images.getFacilitiesScore()+images.getHygieneScore()+images.getServiceScore()+images.getPositionScore())/4);
            boolean add = commentMapper.add(images);
            if(add){
                boolean b = hotelOrderMapper.updateTheOrderStatus(4, images.getOrderId());
                if(b){
                    return DtoUtils.getSuccesDto("评论成功");
                }
            }
        }
        return DtoUtils.getErrorDto(null,"评论失败");
    }

    @Override
    public Dto getpersonalorderroominfo(Long orderId,String token) {
        if (orderId>0&&token!=null){
            String[] split = token.split("-");
            OrderDetails getpersonalorderinfo = commentMapper.getpersonalorderroominfo(orderId,Long.valueOf(split[2]));
            if (getpersonalorderinfo!=null){
                return DtoUtils.getSuccessWhitDataDto("获取个人订单房型信息成功",getpersonalorderinfo);
            }
            return null;
        }
        return null;
    }

    @Override
    public Dto getcommentlist(CommentEntity commentEntity) {
            if(commentEntity.getPageNo()==null){
                commentEntity.setPageNo("1");
            }
            if(commentEntity.getPageSize()==null){
                commentEntity.setPageSize("5");
            }
            PageHelper.startPage(Integer.valueOf(commentEntity.getPageNo()),Integer.valueOf(commentEntity.getPageSize()));
            List<CommentTableDic> getcommentlist = commentMapper.getcommentlist(commentEntity);
            PageInfo<CommentTableDic> pageInfo=new PageInfo<>(getcommentlist);
            Page page=new Page(pageInfo.getStartRow(),pageInfo.getPageNum(), pageInfo.getPages(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
            if(page!=null){
                return DtoUtils.getSuccessWhitDataDto(null,page);
            }
            return DtoUtils.getFailDto(null,null);
    }

    @Override
    public Dto getImg(Long id) {
        return DtoUtils.getSuccessWhitDataDto("获取评论图片成功", commentMapper.getImg(id));
    }
}
