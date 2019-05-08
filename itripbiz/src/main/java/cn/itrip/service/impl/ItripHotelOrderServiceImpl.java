package cn.itrip.service.impl;
import cn.itrip.dao.ItripHotelOrderMapper;
import cn.itrip.dao.pojo.ItripHotel;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.ItripHotelOrder;
import cn.itrip.pojo.ItripUserLinkUser;
import cn.itrip.service.ItripHotelOrderService;
import cn.itrip.utils.DtoUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripHotelOrderServiceImpl implements ItripHotelOrderService {
    @Resource
    private ItripHotelOrderMapper itripHotelOrderMapper;

    @Override
    public List<ItripHotelOrder> queryAll(ItripHotel itripHotel) {
            return itripHotelOrderMapper.queryAll(itripHotel);
    }

    @Override
    public Dto queryuserlinkuser(ItripHotel itripHotel) {
        if(itripHotel!=null){
            return DtoUtils.getSuccessWhitDataDto("获取常用联系人信息成功",itripHotelOrderMapper.queryuserlinkuser(itripHotel));
        }
        return DtoUtils.getFailDto("0","获取常用联系人信息失败");
    }

    @Override
    public Dto adduserlinkuser(ItripUserLinkUser itripUserLinkUser) {
        if(itripUserLinkUser!=null){
            return DtoUtils.getSuccessWhitDataDto("新增常用联系人成功", itripHotelOrderMapper.adduserlinkuser(itripUserLinkUser));
        }
        return DtoUtils.getFailDto("0","新增常用联系人失败");
    }

    @Override
    public Dto deluserlinkuser(Long[] ids) {
        boolean f= itripHotelOrderMapper.deluserlinkuser(ids);
        if (f){
            return DtoUtils.getSuccesDto("删除成功");
        }
        return DtoUtils.getFailDto("0","删除常用联系人失败");
    }

    @Override
    public Dto modifyuserlinkuser(ItripUserLinkUser itripUserLinkUser) {
       if (itripUserLinkUser!=null){
           return DtoUtils.getSuccessWhitDataDto("修改常用联系人成功", itripHotelOrderMapper.modifyuserlinkuser(itripUserLinkUser));
       }
        return DtoUtils.getFailDto("0","修改常用联系人失败");
    }
}
