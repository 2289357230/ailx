package cn.itrip.controller;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.ItripUser;
import cn.itrip.pojo.ToKen;
import cn.itrip.service.AuthService;
import cn.itrip.service.TokenService;
import cn.itrip.utils.DtoUtils;
import cn.itrip.utils.RedisAPI;
import cn.itrip.utils.SDKTestSendTemplateSMS;
import cn.itrip.utils.ValidataCodeUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * @Author: 吴子辉
 * @Date: 2018/12/26 16:41
 * @Description:
 */
@RestController
@RequestMapping("/api/")
public class AutoController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private AuthService authService;
    @Resource
    private SimpleMailMessage simpleMailMessage;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TokenService tokenService;
    @Resource
    private RedisAPI redisAPI;

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public Dto login(String name, String password, HttpServletRequest request){
        ItripUser itripUser=new ItripUser();
        itripUser.setUserCode(name);
        itripUser.setUserPassword(password);
        ItripUser login = authService.login(itripUser);
        if(login!=null) {
            if(login.getActivated()==1) {
                String token = tokenService.generateToken(login, request.getHeader("user-agent"));
                tokenService.save(token,login);
                ToKen toKen = new ToKen(Calendar.getInstance().getTimeInMillis()+2*60*1000*60,Calendar.getInstance().getTimeInMillis(), token);
                return DtoUtils.getSuccessWhitDataDto("登陆成功", toKen);
            }else {
                return DtoUtils.getFailDto("30001","该账号还未激活");
            }
        }
        return DtoUtils.getFailDto("30001","用户名或密码不正确");
    }

    @RequestMapping(value = "registerbyphone",method = RequestMethod.POST)
    public Dto registerbyphone(@RequestBody ItripUser itripUser){
        itripUser.setActivated(0);
        itripUser.setCreationDate(new Date());
        stringRedisTemplate.opsForValue().set(itripUser.getUserCode(),SDKTestSendTemplateSMS.phone(itripUser.getUserCode()),120, TimeUnit.SECONDS);
        if(authService.registerByPhone(itripUser)){
            return DtoUtils.getSuccesDto("注册成功!");
        }
        return DtoUtils.getFailDto("30001","注册失败");
    }

    @RequestMapping(value = "doregister",produces = "application/json",method = RequestMethod.POST,consumes = "application/json")
    public Dto registerByEmail(@RequestBody ItripUser itripUser) throws MessagingException, ParseException {
        itripUser.setActivated(0);
        itripUser.setCreationDate(new Date());
        System.out.println(itripUser.getCreationDate());
        String valiCode= ValidataCodeUtils.getValiCode(0);
        stringRedisTemplate.opsForValue().set(itripUser.getUserCode(),valiCode,20, TimeUnit.MINUTES);
        simpleMailMessage.setTo(itripUser.getUserCode());
        simpleMailMessage.setText("欢迎注册爱旅行项目，请尽快激活你的账号，验证码是:"+valiCode);
        javaMailSender.send(simpleMailMessage);
        int num=authService.registerByEmail(itripUser);
        if(num>0){
            return DtoUtils.getSuccesDto("注册成功!");
        }
        return DtoUtils.getFailDto("30001","注册失败");
    }

    public Dto activate(String user,String code){
        if((stringRedisTemplate.opsForValue().get(user)).equals(code)){
            if(authService.activate(user)){
                return DtoUtils.getSuccesDto("激活成功!");
            }else {
                return DtoUtils.getFailDto("30001","激活失败");
            }
        }
        return DtoUtils.getFailDto("30001","用户名或激活码不正确");
    }

    @RequestMapping(value = "validatephone",method = RequestMethod.PUT)
    public Dto activatePhone(String user,String code){
        return activate(user,code);
    }

    @RequestMapping(value = "activate",method = RequestMethod.PUT)
    public Dto activateEmail(String user,String code){
        return activate(user,code);
    }

    @RequestMapping(value="ckusr",method = RequestMethod.GET)
    public Dto isExits(String name){
        boolean isExits=authService.isExits(name);
        if(isExits) {
            return DtoUtils.getFailDto("30001","用户名已存在!");
        }
        return DtoUtils.getSuccesDto("此用户名可以注册!");
    }

    @RequestMapping(value ="logout",method = RequestMethod.GET,headers = "token")
    public Dto logout(HttpServletRequest request){
        if(tokenService.del(request.getHeader("token"))){
            return DtoUtils.getSuccesDto("注销成功");
        }
        return DtoUtils.getFailDto("30001","注销出错!");
    }

    @RequestMapping(value = "retoken",method = RequestMethod.POST)
    public Dto retoken(String token,HttpServletRequest request){
        if(token!=null){
            ItripUser itripUser = JSONObject.parseObject(stringRedisTemplate.opsForValue().get(token),ItripUser.class);
            redisAPI.delete(token);
            if(tokenService.replace(token,itripUser,request.getHeader("user-agent"))){
                return DtoUtils.getSuccesDto("更新成功");
            }else {
                return DtoUtils.getFailDto(null,"更新失败");
            }
        }
        return DtoUtils.getFailDto(null,"更新失败");
    }
}
