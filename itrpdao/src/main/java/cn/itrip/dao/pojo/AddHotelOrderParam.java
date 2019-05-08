package cn.itrip.dao.pojo;

import cn.itrip.pojo.ItripUserLinkUser;

import java.util.Date;
import java.util.List;

public class AddHotelOrderParam {


    private int bookType;

    private int bookingDays;

    private Date checkInDate;

    private Date checkOutDate;

    private int count;

    private Long hotelId;

    private String hotelName;

    private Long id;

    private String invoiceHead;

    private int invoiceType;

    private String isNeedInvoice;

    private List itripOrderLinkUserList;

    private List<ItripUserLinkUser> linkUser;

    private String linkUserName;

    private Double payAmount;

    private String noticeEmail;

    private Long noticePhone;

    private String orderNo;

    private int orderType;

    private int payType;

    private Long roomId;

    private String specialRequirement;

    private String token;

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public int getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(int bookingDays) {
        this.bookingDays = bookingDays;
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

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getIsNeedInvoice() {
        return isNeedInvoice;
    }

    public void setIsNeedInvoice(String isNeedInvoice) {
        this.isNeedInvoice = isNeedInvoice;
    }

    public List getItripOrderLinkUserList() {
        return itripOrderLinkUserList;
    }

    public void setItripOrderLinkUserList(List itripOrderLinkUserList) {
        this.itripOrderLinkUserList = itripOrderLinkUserList;
    }

    public List<ItripUserLinkUser> getLinkUser() {
        return linkUser;
    }

    public void setLinkUser(List<ItripUserLinkUser> linkUser) {
        this.linkUser = linkUser;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public String getNoticeEmail() {
        return noticeEmail;
    }

    public void setNoticeEmail(String noticeEmail) {
        this.noticeEmail = noticeEmail;
    }

    public Long getNoticePhone() {
        return noticePhone;
    }

    public void setNoticePhone(Long noticePhone) {
        this.noticePhone = noticePhone;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AddHotelOrderParam{" +
                "bookType=" + bookType +
                ", bookingDays=" + bookingDays +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", count=" + count +
                ", hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", id=" + id +
                ", invoiceHead='" + invoiceHead + '\'' +
                ", invoiceType=" + invoiceType +
                ", isNeedInvoice='" + isNeedInvoice + '\'' +
                ", itripOrderLinkUserList=" + itripOrderLinkUserList +
                ", linkUser=" + linkUser +
                ", linkUserName='" + linkUserName + '\'' +
                ", noticeEmail='" + noticeEmail + '\'' +
                ", noticePhone=" + noticePhone +
                ", orderNo='" + orderNo + '\'' +
                ", orderType=" + orderType +
                ", payType=" + payType +
                ", roomId=" + roomId +
                ", specialRequirement='" + specialRequirement + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
