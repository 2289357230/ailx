package cn.itrip.pojo;


import java.util.Date;

public class ItripUser {

  private long id;
  private String userCode;
  private String userPassword;
  private long userType;
  private long flatId;
  private String userName;
  private String weChat;
  private String qq;
  private String weibo;
  private String baidu;
  private Date creationDate;
  private long createdBy;
  private Date modifyDate;
  private long modifiedBy;
  private long activated;


  @Override
  public String toString() {
    return "ItripUser{" +
            "id=" + id +
            ", userCode='" + userCode + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userType=" + userType +
            ", flatId=" + flatId +
            ", userName='" + userName + '\'' +
            ", weChat='" + weChat + '\'' +
            ", qq='" + qq + '\'' +
            ", weibo='" + weibo + '\'' +
            ", baidu='" + baidu + '\'' +
            ", creationDate=" + creationDate +
            ", createdBy=" + createdBy +
            ", modifyDate=" + modifyDate +
            ", modifiedBy=" + modifiedBy +
            ", activated=" + activated +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public long getUserType() {
    return userType;
  }

  public void setUserType(long userType) {
    this.userType = userType;
  }


  public long getFlatId() {
    return flatId;
  }

  public void setFlatId(long flatId) {
    this.flatId = flatId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getWeChat() {
    return weChat;
  }

  public void setWeChat(String weChat) {
    this.weChat = weChat;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getWeibo() {
    return weibo;
  }

  public void setWeibo(String weibo) {
    this.weibo = weibo;
  }


  public String getBaidu() {
    return baidu;
  }

  public void setBaidu(String baidu) {
    this.baidu = baidu;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }


  public long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(long createdBy) {
    this.createdBy = createdBy;
  }


  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(java.sql.Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }


  public long getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(long modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public long getActivated() {
    return activated;
  }

  public void setActivated(long activated) {
    this.activated = activated;
  }

}
