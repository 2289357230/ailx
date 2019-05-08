package cn.itrip.pojo;

public class CommentEntity{

    private Long isOk;

    private Long isHavingImg;

    private Long hotelId;

    private String pageNo;

    private String pageSize;


    public Long getIsOk() {
        return isOk;
    }

    public void setIsOk(Long isOk) {
        this.isOk = isOk;
    }


    public Long getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(Long isHavingImg) {
        this.isHavingImg = isHavingImg;
    }


    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "isOk=" + isOk +
                ", isHavingImg=" + isHavingImg +
                ", hotelId=" + hotelId +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
