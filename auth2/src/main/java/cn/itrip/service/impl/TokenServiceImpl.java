package cn.itrip.service.impl;
import cn.itrip.pojo.ItripUser;
import cn.itrip.service.TokenService;
import cn.itrip.utils.MD5;
import cn.itrip.utils.RedisAPI;
import com.alibaba.fastjson.JSON;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 吴子辉
 * @Date: 2018/12/28 11:01
 * @Description:
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedisAPI redisAPI;

    @Override
    public String generateToken(ItripUser itripUser,String agent) {
        StringBuffer str=new StringBuffer();
        UserAgent userAgent= UserAgent.parseUserAgentString(agent);
        if(userAgent.getOperatingSystem().isMobileDevice()){
            str.append("MB-");
        }else{
            str.append("PC-");
        }
        str.append(MD5.getMd5(itripUser.getUserCode(),32)
                +"-"+itripUser.getId()+"-"+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                + "-"+MD5.getMd5(agent,6));
        return str.toString();
    }

    @Override
    public void save(String token, ItripUser itripUser) {
        if(token.startsWith("PC")){
            redisAPI.set(token,2*60*60, JSON.toJSONString(itripUser));
        }else {
            redisAPI.set(token, JSON.toJSONString(itripUser));
        }
    }

    @Override
    public boolean del(String token) {
        if (token!=null) {
            redisAPI.delete(token);
            return true;
        }
        return false;
    }

    @Override
    public boolean replace(String token,ItripUser itripUser,String agent) {
        String str[]=token.split("-");
        try {
            if(new SimpleDateFormat("yyyyMMddHHmmss").parse(str[3]).getTime()<System.currentTimeMillis()){
                save(generateToken(itripUser, agent),itripUser);
                return true;
            }else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return false;
    }
}
