package cn.itrip.controller;
import cn.itrip.pojo.ItripUser;
import cn.itrip.utils.ValidataCodeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.format.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * @Author: 吴子辉
 * @Date: 2018/12/27 09:33
 * @Description:
 */
public class TestEmail {

    public static void main(String[] args) throws MessagingException {
//        Random random=new Random();
//        int intFlag = (int)(Math.random() * 1000000);
//        Properties prop =new Properties();
//        prop.setProperty("mail.transport.protocol","smtp");//smtp  pop3 ..
//        prop.setProperty("mail.host","smtp.qq.com");//谁 发送邮件的人 服务器  25
//        prop.setProperty("mail.user","2289357230@qq.com");//登录服务器的用户名
//        prop.setProperty("mail.from","2289357230@qq.com");//发送的邮件的人
//        Session session= Session.getInstance(prop);
//        MimeMessage email=new MimeMessage(session);
//        email.setSubject("爱旅行项目组");
//        email.setText("欢迎注册爱旅行，你的验证码是:"+intFlag);
//        email.setRecipient(Message.RecipientType.TO,new InternetAddress("2289357230@qq.com"));
//
//        Transport transport=  session.getTransport();
//        transport.connect("2289357230@qq.com","izkpqkvasomfechi");
//        transport.sendMessage(email,email.getAllRecipients());
//        transport.close();
        ItripUser itripUser=new ItripUser();
        itripUser.setActivated(0);
        itripUser.setCreationDate(new Date());
        String valiCode= ValidataCodeUtils.getValiCode(0);
        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        JavaMailSender javaMailSender=new JavaMailSenderImpl();
        stringRedisTemplate.opsForValue().set(itripUser.getUserName(),valiCode,2*24*60*60, TimeUnit.SECONDS);
        simpleMailMessage.setTo(itripUser.getUserCode());
        simpleMailMessage.setText("欢迎你注册爱旅行项目，请尽快激活你的账号，验证码是:"+valiCode);
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void s(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2);
        System.out.println(System.currentTimeMillis());
        LocalDate localDate=LocalDate.now();
        LocalDate firstDay=LocalDate.of(localDate.getYear(),localDate.getMonth(),1);
        LocalDate lastDay=localDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(firstDay);
        System.out.println(lastDay);
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        System.out.println(dateTimeFormatter.format(calendar.getTime().toInstant()));
    }
}
