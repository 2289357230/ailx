package cn.itrip.pojo;

import java.util.Date;

/**
 * @Author: Goku
 * @Date: 2019/1/4 15:27
 * @Description:
 *
 * 封装入参
 *
 */
public class HotelInfo {
    /**
     * 升序排列字段
     */
    private String ascSort;
    /**
     * 入住时间
     */
    private Date checkInDate;
    /**
     * 退房时间
     */
    private Date checkOutDate;
    /**
     * 倒叙排列字段
     */
    private String descSort;
    /**
     * 目的地
     */
    private String destination;
    /**
     * 酒店特色 IDS
     */
    private String featureIds;
    /**
     * 酒店级别
     */
    private Integer hotelLevel;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 最高价
     */
    private Double maxPrice;
    /**
     * 最低价
     */
    private Integer minPrice;
    /**
     * 页数
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 商圈 ids
     */
    private String tradeAreaIds;

    public String getAscSort() {
        return ascSort;
    }

    public void setAscSort(String ascSort) {
        this.ascSort = ascSort;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getDescSort() {
        return descSort;
    }

    public void setDescSort(String descSort) {
        this.descSort = descSort;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(String featureIds) {
        this.featureIds = featureIds;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTradeAreaIds() {
        return tradeAreaIds;
    }

    public void setTradeAreaIds(String tradeAreaIds) {
        this.tradeAreaIds = tradeAreaIds;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "ascSort='" + ascSort + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", descSort='" + descSort + '\'' +
                ", destination='" + destination + '\'' +
                ", featureIds='" + featureIds + '\'' +
                ", hotelLevel=" + hotelLevel +
                ", keywords='" + keywords + '\'' +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", tradeAreaIds='" + tradeAreaIds + '\'' +
                '}';
    }
}
