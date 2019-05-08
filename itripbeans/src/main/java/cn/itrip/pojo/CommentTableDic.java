package cn.itrip.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.util.Date;

public class CommentTableDic {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Data checkInDate;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    private Long hotelLevel;

    private Long id;

    private Long isHavingImg;

    private String roomTitle;

    private Double score;

    private String tripModeName;

    private String userCode;

    public Data getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Data checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Long hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(Long isHavingImg) {
        this.isHavingImg = isHavingImg;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTripModeName() {
        return tripModeName;
    }

    public void setTripModeName(String tripModeName) {
        this.tripModeName = tripModeName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "CommentTableDic{" +
                "checkInDate=" + checkInDate +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", hotelLevel=" + hotelLevel +
                ", id=" + id +
                ", isHavingImg=" + isHavingImg +
                ", roomTitle='" + roomTitle + '\'' +
                ", score=" + score +
                ", tripModeName='" + tripModeName + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
