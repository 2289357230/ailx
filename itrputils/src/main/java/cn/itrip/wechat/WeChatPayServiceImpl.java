package cn.itrip.wechat;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author feizns
 * @since 2019/1/15 0015
 */
public class WeChatPayServiceImpl implements WeChatPayService {

    private WeChatPaymentArgumentConfig config;

    private HttpClient httpClient = HttpClients.createDefault();

    public WeChatPayServiceImpl(WeChatPaymentArgumentConfig config) {
        this.config = config;
    }

    @Override
    public String getCodeUrl(String outTradeNo, String totalAmount, String body) {
        String xml = config.generateConfig(body, outTradeNo, totalAmount).generateSignedXml();
        WeChatReturn result = sendUnifiedOrderUrl(xml);
        if ( SUCCESS.equals(result.getResultCode()) && SUCCESS.equals(result.getReturnCode()) )
            return result.getCodeUrl();
        return null;
    }

    private WeChatReturn sendUnifiedOrderUrl(String xml) {
        HttpPost httpPost = new HttpPost(UNIFIED_ORDER_URL);
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(new StringEntity(xml, DEFAULT_CHARSET));
        try {
            HttpResponse response = httpClient.execute(httpPost);
            String rXml = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
            return WeChatReturn.parse(rXml);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
