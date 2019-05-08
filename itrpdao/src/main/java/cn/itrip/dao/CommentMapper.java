package cn.itrip.dao;
import cn.itrip.dao.pojo.OrderDetails;
import cn.itrip.dao.pojo.PersonalOrderInfo;
import cn.itrip.dao.pojo.hotelFeatureList;
import cn.itrip.dao.pojo.itripImages;
import cn.itrip.pojo.CommentEntity;
import cn.itrip.pojo.CommentTableDic;
import cn.itrip.pojo.ItripHotel;
import cn.itrip.pojo.ItripImage;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CommentMapper {

    List<hotelFeatureList> gettraveltype();

    ItripHotel gethoteldesc(Long hotelId);

    List<ItripImage> getimg(Long hotelId);

    PersonalOrderInfo getpersonalorderinfo(@Param("id") Long id, @Param("token") Long token);

    boolean add(itripImages images);

    OrderDetails getpersonalorderroominfo(@Param("orderId") Long orderId,@Param("token") Long token);

    List<CommentTableDic> getcommentlist(CommentEntity commentEntity);

    List<ItripImage> getImg(Long id);
}
