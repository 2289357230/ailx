package cn.itrip.controller;
import cn.itrip.dao.HotelOrderMapper;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.utils.DtoUtils;
import cn.itrip.wechat.WeChatPayService;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import static cn.itrip.wechat.WeChatPayService.OK;
import static cn.itrip.wechat.WeChatPayService.SUCCESS;
import static cn.itrip.wechat.WeChatPayService.WeChatPaymentArgumentConfig.DEFAULT_TOTAL_FEE;

@RestController
@RequestMapping("api/wxpay/")
public class WxPayController {

    @Resource
    private WeChatPayService weChatPayService;

    @Resource
    private HotelOrderMapper hotelOrderMapper;

    @GetMapping("createqccode/{orderNo}")
    public Dto createWeChatCode(@PathVariable String orderNo){
        ItripHotelOrder itripHotelOrder = hotelOrderMapper.selectOrderNo(orderNo);
        if(itripHotelOrder!=null){
            itripHotelOrder.setCodeUrl(weChatPayService.getCodeUrl(itripHotelOrder.getOrderNo(), DEFAULT_TOTAL_FEE,itripHotelOrder.getHotelName()));
        }
        return DtoUtils.getSuccessWhitDataDto(null,itripHotelOrder);
    }

    @GetMapping("queryorderstatus/{orderNo}")
    public Dto queryOrderStatus(@PathVariable String orderNo){
        return DtoUtils.getSuccessWhitDataDto(null,hotelOrderMapper.selectOrderNo(orderNo));
    }

    @PostMapping(value = "notifyUrl",produces = "text/xml;charset=utf-8")
    public void notifyUrl(InputStream i, HttpServletResponse response) throws Exception {
        String str = IOUtils.toString(i, weChatPayService.DEFAULT_CHARSET);
        WeChatPayService.WeChatReturn weChatReturn=WeChatPayService.WeChatReturn.parse(str);
        if (SUCCESS.equals(weChatReturn.getReturnCode())&&SUCCESS.equals(weChatReturn.getResultCode())) {
        hotelOrderMapper.updateTheOrderStatusByOrderNo(2,weChatReturn.getOutTradeNo());
        }
        PrintWriter out = response.getWriter();
        out.print(new WeChatPayService.WeChatReturn().setReturnCode(SUCCESS).setReturnMsg(OK).toXml());
        out.flush();
    }
}