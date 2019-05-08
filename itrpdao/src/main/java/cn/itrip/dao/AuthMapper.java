package cn.itrip.dao;
import cn.itrip.pojo.ItripUser;
/**
 * @Author: 吴子辉
 * @Date: 2018/12/26 16:44
 * @Description:
 */
@SuppressWarnings("all")
public interface AuthMapper {

    ItripUser login(ItripUser itripUser);

    int registerByPhone(ItripUser itripUser);

    int registerByEmail(ItripUser itripUser);

    int activate(String name);

    int isExits(String name);
}
