package cn.itrip.dao.pojo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Goku
 * @Date: 2019/1/4 17:07
 * @Description:
 */
public class Page {
    /**
     * 开始位置
     */
    private Integer beginPos;
    /**
     * 当前页
     */
    private Integer curPage;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 每页显示的条数
     */
    private Integer pageSize;
    /**
     * 数据
     */
    private List rows;
    /**
     * 总条数
     */
    private Long total;

    @Override
    public String toString() {
        return "Page{" +
                "beginPos=" + beginPos +
                ", curPage=" + curPage +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Page(Integer beginPos, Integer curPage, Integer pageCount, Integer pageSize, List rows, Long total) {
        this.beginPos = beginPos;
        this.curPage = curPage;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.rows = rows;
        this.total = total;
    }

    public Page() {
    }
}
