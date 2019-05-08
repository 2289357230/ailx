package cn.itrip.config;
import java.io.FileWriter;
import java.io.IOException;
/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092400587186";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC270OlZ+7B0suKfpORYX0W3tezXcby47mz0a3o+gg2FP7vqLyiLLzsy3Z0RwQep4dOOTXPI2i1qsyEpcXAh5VpVlKnpCs2kmKGwq9HINbzfnZBN1c2ZkJRaeXkCpidE5xKcIfQXpr9jDfThXF4NsRVxWbx++qTT5Oa9gJsjZ+Eubsum6rvZvFAP3sjT0jL844ppv1lSIlgWBygG8vmdIQl8QAql52DLz/nHATjz8WmTMKKLEFldwC1MdNwFpCjb5goNnMwg5HHcJC7b+eno3DNslDk2ck08xeB+QcmylzPZ38fV71g75qDb0sC7SVQoAfOiGEy23mt9fvzAwgWclbRAgMBAAECggEAcDjfer0DjwvNqax0wp7XqgwSrwo8Xgytg06CLYYVO3gt3L/a2HIxg+JdTH+0W0nSi341MFk8hxW8WTOI2M9ULUazdfwUNmoe3yTXef7/XmiaCu/0JH8e9+rLCNYnQVUib9gQuRcQZbJ7HNuj/Gc8kpGC0bgE81HB7zIz0nwe+8AXjHnVqFZ1ogQrIdVbuuVyW8JFkr8qgvKrXh7LQINKK2M9AzgiDZamtFpOaDhg2VfpJ524RrJ7Ih4A9ewup8o7tRJl5nRYi2B9Whh99khsAlLX2jYvkwuI+XWHgwObToz+IhCGWURWkd7k2VFYb+d8Btel0tX28wX/3ZSs1is3sQKBgQD/m4tEKe8DBsOVpifNGSfK32tavGSmp1/BiTVd9Erkbv0VwbYgLgJCFdzwDGeNqNH/wVCRqG92oeWbSQSUSdRwT2dxTV3PiPtjnqofJN5TUngm5gZI4jIWrPEyzWaQbCp+2wNwLEmcU+HEDFlFiG3oVRvDgX7SeboehzrTK0HV/wKBgQC3Nyi8vp3EPy2Egu7NYSGdVPOsgpqZoqabhha8zkjVSWWclTeLgjPQyuXeFxCLNyobS9UkL19mSTx1j76+6pOEkABtCNq675H6b5bxgAEIHrOd+sNxl/zBiFmBhFaKBjg1U79Mga2pE3m4OJUI23onIEFqGZzGhqYoowx6BsXzLwKBgQCa2InXs2ed970IrW2zLCgVGKAaicKXyxGRVyPDVTkBhdNAGOfSOs0XZ9M+gOVCxiDhxSSf+N/9iDpmhieGBevyVcgetXW9Qgi44ufAkj81TuKG/haUlKMvZXmBAzm9CCn+S4ObstitIYvFjo2OOAYNF3IIUCyaKS/9SoLyZmQt1QKBgGB5NgU05gQpNEGbZD1XEQk0a18CIoAVql8oWx6uDKHqlQu/ctEODVS7EhFA2eBEevKGmsQEAdrtY12QBGOpR2Y9IUxIpkxay+YwDi46NdDdwbzFB1bwLhKGRoMxeRQStFQ4NfoGKrhl3ekIOknAr/CcRnWk6O2Mhz/Mo0w59s/XAoGBAOJofnsODIW/jJcaUe+MO4SPAEakIy3TGoLTCqWf5Ba0mcvxMyuvE66/3gpPJ6d4Z9C9hogEXnZBxGrfWkCgU6h52kFJrhiQHHtTU2dCVakb5vJ4TQ9wM1lMIXgJmOmrfiLhHgsHXNc269LdRnDhhxkG2T/1B5FRhgqJxrPMwLwB";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AM IIBCgKCAQEAyVnEQwaGd3NXoeZiioEjoBjOewOpyYQaZA1+Isd/PuXwdXEtRidDrGJHoAQPbs5bdTntBM9gEntwUJOR2W/QXEAOugdbUvLggnVRJTiDmzWy+Q88IvUi7ZGEWefCDnLNK73UBedKlnHk7agAZXWhfTiI3vYRY4NxgTG3CKaaboD+I92bhwYUiyArTOx3dI5EfxEKOjCxFmLyZ9qc0rko4GmVE6t5mZsvX/NqTHq8MZwBLvmRN1T+BKprgjZEcCMqJi/H0GAwUm+0AZZ4VwUpLeJFABQg/PGlmi4OcYBJ7nC8Wz2UIyBm9/2my81ZqPj5DOD6ONH7T2AmloEb8t+LQwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://z64jrb.natappfree.cc/trade/api/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://z64jrb.natappfree.cc/trade/api/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

