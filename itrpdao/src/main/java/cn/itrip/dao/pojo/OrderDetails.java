package cn.itrip.dao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDetails{

    private String address;

    private Long bookingDays;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;

    private Long checkInWeek;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;

    private Long checkOutWeek;

    private Long count;

    private Long hotelId;

    private Long hotelLevel;

    private String hotelName;

    private Long id;

    private Long isHavingBreakfast;

    private String linkUserName;

    private double payAmount;

    private Long roomBedTypeId;

    private String roomBedTypeName;

    private Long roomId;

    private Long roomPayType;

    private String roomTitle;

    private String specialRequirement;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(Long bookingDays) {
        this.bookingDays = bookingDays;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Long getCheckInWeek() {
        return checkInWeek;
    }

    public void setCheckInWeek(Long checkInWeek) {
        this.checkInWeek = checkInWeek;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Long getCheckOutWeek() {
        return checkOutWeek;
    }

    public void setCheckOutWeek(Long checkOutWeek) {
        this.checkOutWeek = checkOutWeek;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Long hotelLevel) {
        this.hotelLevel = hotelLevel;
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

    public Long getIsHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setIsHavingBreakfast(Long isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public Long getRoomBedTypeId() {
        return roomBedTypeId;
    }

    public void setRoomBedTypeId(Long roomBedTypeId) {
        this.roomBedTypeId = roomBedTypeId;
    }

    public String getRoomBedTypeName() {
        return roomBedTypeName;
    }

    public void setRoomBedTypeName(String roomBedTypeName) {
        this.roomBedTypeName = roomBedTypeName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomPayType() {
        return roomPayType;
    }

    public void setRoomPayType(Long roomPayType) {
        this.roomPayType = roomPayType;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "address='" + address + '\'' +
                ", bookingDays=" + bookingDays +
                ", checkInDate=" + checkInDate +
                ", checkInWeek=" + checkInWeek +
                ", checkOutDate=" + checkOutDate +
                ", checkOutWeek=" + checkOutWeek +
                ", count=" + count +
                ", hotelId=" + hotelId +
                ", hotelLevel=" + hotelLevel +
                ", hotelName='" + hotelName + '\'' +
                ", id=" + id +
                ", isHavingBreakfast=" + isHavingBreakfast +
                ", linkUserName='" + linkUserName + '\'' +
                ", payAmount=" + payAmount +
                ", roomBedTypeId=" + roomBedTypeId +
                ", roomBedTypeName='" + roomBedTypeName + '\'' +
                ", roomId=" + roomId +
                ", roomPayType=" + roomPayType +
                ", roomTitle='" + roomTitle + '\'' +
                ", specialRequirement='" + specialRequirement + '\'' +
                '}';
    }
}
