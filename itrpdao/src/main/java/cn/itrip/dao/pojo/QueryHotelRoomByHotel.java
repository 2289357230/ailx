package cn.itrip.dao.pojo;

import cn.itrip.pojo.ItripHotelRoom;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QueryHotelRoomByHotel extends ItripHotelRoom {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
