package cn.itrip.wechat;

import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author feizns
 * @since 2019/1/15 0015
 */
public interface WeChatPayService {

    /**
     * 统一下单url
     */
    String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 默认字符编码
     */
    String DEFAULT_CHARSET = "UTF-8";

    /**
     * 成功
     */
    String SUCCESS = "SUCCESS";

    /**
     *
     */
    String OK = "OK";

    /**
     * 请求二维码链接
     * @param outTradeNo
     * @param totalAmount
     * @param body
     * @return
     */
    String getCodeUrl(String outTradeNo, String totalAmount, String body);

    /**
     * @author feizns
     * @since 2019/1/15 0015
     */
    class WeChatPaymentArgumentConfig {

        public static final String DEFAULT_KEY = "2ab9071b06b9f739b950ddb41db2690d";

        /**
         * 默认的 appid
         */
        public static final String DEFAULT_APP_ID = "wxab8acb865bb1637e";

        /**
         * 默认的 mch_id
         */
        public static final String DEFAULT_MCH_ID = "11473623";

        /**
         * 默认的 spbillCreateIp
         */
        public static final String DEFAULT_SPBILL_CREATE_IP = "123.12.12.123";

        /**
         * 默认的 trade_type
         */
        public static final String DEFAULT_TRADE_TYPE = "NATIVE";

        /**
         * 默认的 PRODUCT_ID
         */
        public static final String DEFAULT_PRODUCT_ID = "12";

        /**
         * 默认的 sign_type
         */
        public static final String DEFAULT_SIGN_TYPE = "MD5";

        /**
         * 默认签名
         */
        public static final String DEFAULT_SIGN = "2ab9071b06b9f739b950ddb41db2690d";

        /**
         * 默认的支付金额
         */
        public static final String DEFAULT_TOTAL_FEE = "1";

        /**
         * 公众账号ID
         */
        private String appid = DEFAULT_APP_ID;

        /**
         * 商户号
         */
        private String mchId = DEFAULT_MCH_ID;

        /**
         * 随机字符串
         */
        private String nonceStr;

        /**
         * 签名
         */
        private String sign;

        /**
         * 签名类型
         */
        private String signType;

        /**
         * 商品描述
         */
        private String body;

        /**
         * 商户订单号
         */
        private String outTradeNo;

        /**
         * 标价金额：（单位：分）
         */
        private String totalFee = DEFAULT_TOTAL_FEE;

        /**
         * 终端IP
         */
        private String spbillCreateIp = DEFAULT_SPBILL_CREATE_IP;

        /**
         * 异步通知地址
         */
        private String notifyUrl;

        /**
         * 交易类型
         */
        private String tradeType = DEFAULT_TRADE_TYPE;

        /**
         * 交易类型 为NAVITE是对应为12 其他时候可以不填
         */
        private String productId = DEFAULT_PRODUCT_ID;

        public static final WeChatPaymentArgumentConfig createArgumentConfig(String body, String outTradeNo, String totalFee, String notifyUrl) {
            WeChatPaymentArgumentConfig result = new WeChatPaymentArgumentConfig();
            return result.setBody(body).setOutTradeNo(outTradeNo).setTotalFee(totalFee).setNotifyUrl(notifyUrl);
        }

        public WeChatPaymentArgumentConfig generateConfig(String body, String outTradeNo, String totalFee) {
            WeChatPaymentArgumentConfig result = new WeChatPaymentArgumentConfig();
            BeanUtils.copyProperties(this, result);
            result.setBody(body)
                    .setOutTradeNo(outTradeNo)
                    .setTotalFee(totalFee);
            return result;
        }

        public Map<String, String> toMap() {
            return Utils.humpToUnderlineMap(this);
        }

        public String toXml() throws Exception {
            return WXPayUtil.mapToXml(toMap());
        }

        public String generateSignedXml(String key) throws Exception {
            if ( nonceStr == null )
                nonceStr =WXPayUtil.generateNonceStr();
            return WXPayUtil.generateSignedXml(toMap(), key);
        }

        public String generateSignedXml() {
            try {
                return generateSignedXml(DEFAULT_KEY);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public String getAppid() {
            return appid;
        }

        public WeChatPaymentArgumentConfig setAppid(String appid) {
            this.appid = appid;
            return this;
        }

        public String getMchId() {
            return mchId;
        }

        public WeChatPaymentArgumentConfig setMchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public WeChatPaymentArgumentConfig setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }

        public String getSign() {
            return sign;
        }

        public WeChatPaymentArgumentConfig setSign(String sign) {
            this.sign = sign;
            return this;
        }

        public String getSignType() {
            return signType;
        }

        public WeChatPaymentArgumentConfig setSignType(String signType) {
            this.signType = signType;
            return this;
        }

        public String getBody() {
            return body;
        }

        public WeChatPaymentArgumentConfig setBody(String body) {
            this.body = body;
            return this;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public WeChatPaymentArgumentConfig setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public String getTotalFee() {
            return totalFee;
        }

        public WeChatPaymentArgumentConfig setTotalFee(String totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public String getSpbillCreateIp() {
            return spbillCreateIp;
        }

        public WeChatPaymentArgumentConfig setSpbillCreateIp(String spbillCreateIp) {
            this.spbillCreateIp = spbillCreateIp;
            return this;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public WeChatPaymentArgumentConfig setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public String getTradeType() {
            return tradeType;
        }

        public WeChatPaymentArgumentConfig setTradeType(String tradeType) {
            this.tradeType = tradeType;
            return this;
        }

        public String getProductId() {
            return productId;
        }

        public WeChatPaymentArgumentConfig setProductId(String productId) {
            this.productId = productId;
            return this;
        }
    }

    public static class WeChatReturn {

        public static final WeChatReturn parse(String xml) throws Exception {
            Map<String, String> map = WXPayUtil.xmlToMap(xml);
            if ( map != null )
                return Utils.underlineMapStringToJavaBean(map, WeChatReturn.class);
            return null;
        }

        /**
         * 返回状态码
         */
        private String returnCode;

        /**
         * 返回信息
         */
        private String returnMsg;

        /**
         * 业务结果
         */
        private String resultCode;

        /**
         * 错误码
         */
        private String errCode;

        /**
         * 错误码描述
         */
        private String errCodeDes;

        /**
         * 交易类型
         */
        private String tradeType;

        /**
         * 预支付交易会话标识
         */
        private String prepayId;

        /**
         * 二维码链接
         */
        private String codeUrl;

        /**
         * 订单编号
         */
        private String outTradeNo;

        /**
         * 事务编号
         */
        private String transactionId;

        public Map<String, String> toMap() {
            return Utils.humpToUnderlineMap(this);
        }

        public String toXml() throws Exception {
            return WXPayUtil.mapToXml(toMap());
        }

        public String getReturnCode() {
            return returnCode;
        }

        public WeChatReturn setReturnCode(String returnCode) {
            this.returnCode = returnCode;
            return this;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public WeChatReturn setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
            return this;
        }

        public String getResultCode() {
            return resultCode;
        }

        public WeChatReturn setResultCode(String resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public String getErrCode() {
            return errCode;
        }

        public WeChatReturn setErrCode(String errCode) {
            this.errCode = errCode;
            return this;
        }

        public String getErrCodeDes() {
            return errCodeDes;
        }

        public WeChatReturn setErrCodeDes(String errCodeDes) {
            this.errCodeDes = errCodeDes;
            return this;
        }

        public String getTradeType() {
            return tradeType;
        }

        public WeChatReturn setTradeType(String tradeType) {
            this.tradeType = tradeType;
            return this;
        }

        public String getPrepayId() {
            return prepayId;
        }

        public WeChatReturn setPrepayId(String prepayId) {
            this.prepayId = prepayId;
            return this;
        }

        public String getCodeUrl() {
            return codeUrl;
        }

        public WeChatReturn setCodeUrl(String codeUrl) {
            this.codeUrl = codeUrl;
            return this;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public WeChatReturn setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public WeChatReturn setTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
    }

}

