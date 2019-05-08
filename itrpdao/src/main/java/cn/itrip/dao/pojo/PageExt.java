package cn.itrip.dao.pojo;

import cn.itrip.pojo.ItripComment;

public class PageExt extends ItripComment {

    private Long pageNo;

    private Long pageSize;

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
