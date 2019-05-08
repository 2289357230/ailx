package cn.itrip.pojo;


import java.util.Date;

public class ItripUserLinkUser extends ToKen {

  private long id;
  private String linkUserName;
  private String linkIdCard;
  private String linkPhone;
  private long userId;
  private Date creationDate;
  private long createdBy;
  private Date modifyDate;
  private long modifiedBy;
  private long linkIdCardType;

  public ItripUserLinkUser(Long expTime, Long genTime, String token) {
    super(expTime, genTime, token);
  }

  public ItripUserLinkUser() {
    super(null, null, null);
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getLinkUserName() {
    return linkUserName;
  }

  public void setLinkUserName(String linkUserName) {
    this.linkUserName = linkUserName;
  }


  public String getLinkIdCard() {
    return linkIdCard;
  }

  public void setLinkIdCard(String linkIdCard) {
    this.linkIdCard = linkIdCard;
  }


  public String getLinkPhone() {
    return linkPhone;
  }

  public void setLinkPhone(String linkPhone) {
    this.linkPhone = linkPhone;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }


  public long getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(long modifiedBy) {
    this.modifiedBy = modifiedBy;
  }


  public long getLinkIdCardType() {
    return linkIdCardType;
  }

  public void setLinkIdCardType(long linkIdCardType) {
    this.linkIdCardType = linkIdCardType;
  }

  @Override
  public String toString() {
    return "ItripUserLinkUser{" +
            "id=" + id +
            ", linkUserName='" + linkUserName + '\'' +
            ", linkIdCard='" + linkIdCard + '\'' +
            ", linkPhone='" + linkPhone + '\'' +
            ", userId=" + userId +
            ", creationDate=" + creationDate +
            ", createdBy=" + createdBy +
            ", modifyDate=" + modifyDate +
            ", modifiedBy=" + modifiedBy +
            ", linkIdCardType=" + linkIdCardType +
            '}';
  }
}
