package cn.itrip.controller;
import cn.itrip.dao.pojo.Page;
import cn.itrip.dto.Dto;
import cn.itrip.dao.pojo.ItripHotel;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripUserLinkUser;
import cn.itrip.service.ItripHotelOrderService;
import cn.itrip.utils.DtoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonalCenterController {

    @Resource
    private ItripHotelOrderService itripHotelOrderService;

    @RequestMapping(value = "hotelorder/getpersonalorderlist",method = RequestMethod.POST,headers = "token")
    public Dto getpersonalorderlist(HttpServletRequest request,@RequestBody ItripHotel itripHotel) {
        if (request.getHeader("token") != null) {
            String[] tokens = request.getHeader("token").split("-");
            if (itripHotel.getPageNo() == null) {
                itripHotel.setPageNo("1");
            }
            itripHotel.setUserId(Integer.parseInt(tokens[2]));
            PageHelper.startPage(Integer.parseInt(itripHotel.getPageNo()), Integer.parseInt(itripHotel.getPageSize()));
            List<ItripHotelOrder> itripHotelOrders = itripHotelOrderService.queryAll(itripHotel);
            PageInfo pageInfo = new PageInfo(itripHotelOrders);
            Page page = new Page(pageInfo.getStartRow(),pageInfo.getPageNum(), pageInfo.getPages(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
            return DtoUtils.getSuccessWhitDataDto("获取个人订单列表成功",page);
        }
            return DtoUtils.getErrorDto("","");
    }

    @RequestMapping(value = "userinfo/queryuserlinkuser",method = RequestMethod.POST)
    public Dto queryuserlinkuser(@RequestBody ItripHotel itripHotel){
        return itripHotelOrderService.queryuserlinkuser(itripHotel);
    }

    @RequestMapping(value = "userinfo/adduserlinkuser",method = RequestMethod.POST,headers = "token")
    public Dto adduserlinkuser(@RequestBody ItripUserLinkUser itripUserLinkUser,HttpServletRequest request){
        String[] tokens = request.getHeader("token").split("-");
        itripUserLinkUser.setToken(tokens[2]);
        itripUserLinkUser.setUserId(Long.parseLong(tokens[2]));
        itripUserLinkUser.setCreatedBy(Long.parseLong(tokens[2]));
        itripUserLinkUser.setModifiedBy(Long.parseLong(tokens[2]));
        itripUserLinkUser.setModifyDate(new Date());
        itripUserLinkUser.setCreationDate(new Date());
        itripUserLinkUser.setLinkIdCardType(0L);
        return itripHotelOrderService.adduserlinkuser(itripUserLinkUser);
    }

    @RequestMapping(value = "userinfo/deluserlinkuser",method = RequestMethod.GET)
    public Dto deluserlinkuser(Long[] ids){
        return itripHotelOrderService.deluserlinkuser(ids);
    }

    @RequestMapping(value = "userinfo/modifyuserlinkuser",method = RequestMethod.POST)
    public Dto modifyuserlinkuser(@RequestBody ItripUserLinkUser itripUserLinkUser){
        return itripHotelOrderService.modifyuserlinkuser(itripUserLinkUser);
    }

}
