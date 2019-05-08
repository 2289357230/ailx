package cn.itrip.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author feizns
 * @since 2018/12/26 0026
 */
public class Utils {

    private Utils() {}

    /**
     * 默认的随机数上限
     */
    public static final int RANDOM_NUMBER_LIMIT = 10;

    private static final Random random = new Random();

    /**
     * 分隔id的字符
     */
    public static final String SPLIT_ID_STRING = ",";

    /**
     * UUID + ':' + System.currentTimeMillis()
     * @return
     */
    public static String getUUIDCode() {
        return UUID.randomUUID().toString() + ":" + System.currentTimeMillis();
    }

    /**
     * 解析数字
     * @param ids
     * @return
     */
    public static Integer[] parseInts(String ids) {
        if ( ids != null ) {
            if ( ids.contains(SPLIT_ID_STRING) ) {
                String[] split = ids.split(SPLIT_ID_STRING);
                int[] result = new int[split.length];
                for (int i = 0; i < result.length; i++) {
                    result[i] = parseInt(split[i]);
                }
            }
            Integer temp = parseInt(ids);
            return temp == null ? null : new Integer[]{ temp };
        }
        return null;
    }

    public static Integer[] parseInts(String... ids) {
        if ( ids != null )
            return Arrays.stream(ids).map(Utils::parseInt).filter(Objects::nonNull).toArray(Integer[]::new);
        return null;
    }

    private static Integer parseInt(String id) {
        try {
            return Integer.valueOf(id);
        } catch ( NumberFormatException e ) {
            return null;
        }
    }

    /**
     * 求平均
     * @param numbers
     * @return
     */
    public static Integer intSum(Integer... numbers) {
        try {
            OptionalDouble average = Arrays.stream(numbers).mapToInt(item -> item).average();
            return average.isPresent() ? (int) average.getAsDouble() : null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * 随机生成指定位数验证码
     * @param number
     * @return
     */
    public static String getNumber(int number) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < number; i++) {
            r.append(random.nextInt(RANDOM_NUMBER_LIMIT));
        }
        return r.toString();
    }

    public static <T> T copyTo(Object source, Class<T> targetType) {
        try {
            T result = targetType.newInstance();
            BeanUtils.copyProperties(source, result);
            return result;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] md5Array = md5.digest();
            return bytesToHex(md5Array);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return "";
        }
    }

    private static String bytesToHex(byte[] md5Array) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < md5Array.length; i++) {
            int temp = 0xff & md5Array[i];
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {
                strBuilder.append("0").append(hexString);
            } else {
                strBuilder.append(hexString);
            }
        }
        return strBuilder.toString();
    }

    /**
     * 驼峰转下滑线
     * @param name
     * @return
     */
    public static String humpToUnderline(String name) {
        StringBuilder result = new StringBuilder();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ( Character.isUpperCase(chars[i]) )
                result.append("_" + Character.toLowerCase(chars[i]));
            else
                result.append(chars[i]);
        }
        return result.toString();
    }

    /**
     * 下滑线转驼峰
     * @param name
     * @return
     */
    public static String underLineToHump(String name) {
        StringBuilder result = new StringBuilder();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if ( temp == '_' ) {
                if ( i != 0 ) {
                    if ( i + 1 < chars.length ) {
                        result.append(Character.toUpperCase(chars[++i]));
                        continue;
                    }
                }
            }
            result.append(temp);
        }
        return result.toString();
    }

    /**
     * 获取驼峰转下划线的map
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Map<String, String> humpToUnderlineMap(T obj) {
        Map<String, String> map = new LinkedHashMap<>();
        PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(obj.getClass());
        for (int i = 0; i < descriptors.length; i++) {
            if ( descriptors[i].getReadMethod().getDeclaringClass() != Object.class ) {
                try {
                    Object value = descriptors[i].getReadMethod().invoke(obj);
                    if ( value != null )
                        map.put(Utils.humpToUnderline(descriptors[i].getName()), value.toString());
                } catch (ReflectiveOperationException e) {
                    //
                }
            }
        }
        return map;
    }

    public static <T> T underlineMapStringToJavaBean(Map<String, String> map, Class<T> clz) {
        try {
            T bean = clz.newInstance();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String temp = underLineToHump(entry.getKey());
                PropertyDescriptor descriptor = BeanUtils.getPropertyDescriptor(clz, temp);
                if ( descriptor != null ) {
                    try {
                        Method method = descriptor.getWriteMethod();
                        method.invoke(bean, entry.getValue());
                    } catch (InvocationTargetException e) {
                        //
                    }
                }
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static String toJSONString(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static <T> T parseObject(String jsonString, Class<T> targetType) {
        return JSONObject.parseObject(jsonString, targetType);
    }

    public static <T> List<T> parseArray(String jsonString, Class<T> targetType) {
        return JSONArray.parseArray(jsonString, targetType);
    }


}