package cn.itrip.service;
import cn.itrip.pojo.ItripUser;
import javax.mail.MessagingException;

/**
 * @Author: 吴子辉
 * @Date: 2018/12/26 16:42
 * @Description:
 */
public interface AuthService {

    ItripUser login(ItripUser itripUser);

    boolean registerByPhone(ItripUser itripUser);

    int registerByEmail(ItripUser itripUser) throws MessagingException;

    boolean activate(String name);

    boolean isExits(String name);
}
