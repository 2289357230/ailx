package cn.itrip.pojo;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @Author: Goku
 * @Date: 2019/1/4 15:27
 * @Description:
 *
 * 封装出参
 *
 */
public class ShowHotelInfo {
    /**
     * 地址
     */
    @Field
    private String address;
    /**
     * 综合评分
     */
    @Field
    private Double avgScore;
    /**
     * 总评论数量
     */
    @Field
    private Integer commentCount;
    /**
     * 扩展名(酒店设施)
     */
    @Field
    private String extendPropertyNames;
    /**
     * 扩展图
     */
    @Field
    private String extendPropertyPics;
    /**
     * 酒店特色
     */
    @Field
    private String featureNames;
    /**
     * 酒店星级
     */
    @Field
    private Integer hotelLevel;
    /**
     * 酒店名称
     */
    @Field
    private String hotelName;
    /**
     * 酒店ID
     */
    @Field
    private Integer id;
    /**
     * 图片地址
     */
    @Field
    private String imgUrl;
    /**
     * 好评总数
     */
    @Field
    private Integer isOkCount;
    /**
     * 最高价格
     */
    @Field
    private Integer maxPrice;
    /**
     * 最低价格
     */
    @Field
    private Integer minPrice;
    /**
     * 城市名称
     */
    @Field
    private String redundantCityName;
    /**
     * 国家名称
     */
    @Field
    private String redundantCountryName;
    /**
     * 省份名称
     */
    @Field
    private String redundantProvinceName;
    /**
     * 商圈
     */
    @Field
    private String tradingAreaNames;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getExtendPropertyNames() {
        return extendPropertyNames;
    }

    public void setExtendPropertyNames(String extendPropertyNames) {
        this.extendPropertyNames = extendPropertyNames;
    }

    public String getExtendPropertyPics() {
        return extendPropertyPics;
    }

    public void setExtendPropertyPics(String extendPropertyPics) {
        this.extendPropertyPics = extendPropertyPics;
    }

    public String getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(String featureNames) {
        this.featureNames = featureNames;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsOkCount() {
        return isOkCount;
    }

    public void setIsOkCount(Integer isOkCount) {
        this.isOkCount = isOkCount;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public String getRedundantCityName() {
        return redundantCityName;
    }

    public void setRedundantCityName(String redundantCityName) {
        this.redundantCityName = redundantCityName;
    }

    public String getRedundantCountryName() {
        return redundantCountryName;
    }

    public void setRedundantCountryName(String redundantCountryName) {
        this.redundantCountryName = redundantCountryName;
    }

    public String getRedundantProvinceName() {
        return redundantProvinceName;
    }

    public void setRedundantProvinceName(String redundantProvinceName) {
        this.redundantProvinceName = redundantProvinceName;
    }

    public String getTradingAreaNames() {
        return tradingAreaNames;
    }

    public void setTradingAreaNames(String tradingAreaNames) {
        this.tradingAreaNames = tradingAreaNames;
    }

    @Override
    public String toString() {
        return "ShowHotelInfo{" +
                "address='" + address + '\'' +
                ", avgScore=" + avgScore +
                ", commentCount=" + commentCount +
                ", extendPropertyNames='" + extendPropertyNames + '\'' +
                ", extendPropertyPics='" + extendPropertyPics + '\'' +
                ", featureNames='" + featureNames + '\'' +
                ", hotelLevel=" + hotelLevel +
                ", hotelName='" + hotelName + '\'' +
                ", id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", isOkCount=" + isOkCount +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", redundantCityName='" + redundantCityName + '\'' +
                ", redundantCountryName='" + redundantCountryName + '\'' +
                ", redundantProvinceName='" + redundantProvinceName + '\'' +
                ", tradingAreaNames='" + tradingAreaNames + '\'' +
                '}';
    }
}
