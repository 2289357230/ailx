package cn.itrip.service;

import cn.itrip.pojo.ItripUser;

/**
 * @Author: 吴子辉
 * @Date: 2018/12/28 10:52
 * @Description:
 */
public interface TokenService {

    String generateToken(ItripUser itripUser,String agent);

    void  save(String token,ItripUser itripUser);

    boolean del(String token);

    boolean replace(String token,ItripUser itripUser,String agent);
}
