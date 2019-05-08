package cn.itrip.dao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Map;

public class PersonalOrderInfo {

    private Long bookType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    private Long id;

    private String noticePhone;

    private String orderNo;

    private Map<String, String> orderProcess;

    private Long orderStatus;

    private Double payAmount;

    private Long payType;

    private String processNode;

    private Long roomPayType;

    public Long getBookType() {
        return bookType;
    }

    public void setBookType(Long bookType) {
        this.bookType = bookType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticePhone() {
        return noticePhone;
    }

    public void setNoticePhone(String noticePhone) {
        this.noticePhone = noticePhone;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Map<String, String> getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(Map<String, String> orderProcess) {
        this.orderProcess = orderProcess;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public String getProcessNode() {
        return processNode;
    }

    public void setProcessNode(String processNode) {
        this.processNode = processNode;
    }

    public Long getRoomPayType() {
        return roomPayType;
    }

    public void setRoomPayType(Long roomPayType) {
        this.roomPayType = roomPayType;
    }
}
