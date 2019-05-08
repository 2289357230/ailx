package cn.itrip.service.impl;
import cn.itrip.dao.AuthMapper;
import cn.itrip.pojo.ItripUser;
import cn.itrip.service.AuthService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.mail.MessagingException;
/**
 * @Author: 吴子辉
 * @Date: 2018/12/26 16:42
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthMapper authMapper;


    @Override
    public ItripUser login(ItripUser itripUser) {
        return authMapper.login(itripUser);
    }

    @Override
    public boolean registerByPhone(ItripUser itripUser)
    {
        return authMapper.registerByPhone(itripUser)>0;
    }

    @Override
    public int registerByEmail(ItripUser itripUser) throws MessagingException {
       return authMapper.registerByEmail(itripUser);
    }

    @Override
    public boolean activate(String name) {
        return authMapper.activate(name)>0;
    }

    @Override
    public boolean isExits(String name) {
        return authMapper.isExits(name)>0;
    }
}
