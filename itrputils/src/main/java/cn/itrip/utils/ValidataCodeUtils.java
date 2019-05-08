package cn.itrip.utils;

import java.util.Random;
import java.util.UUID;

public class ValidataCodeUtils {
    private static Random random=new Random();
    public static String getValiCode(int length){
        if(length<0){

        }
        return UUID.randomUUID().toString().replace("-","");

    }

    public static String getPhoneCode() {

        return ""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
    }
}
