package com.shawn.learningalways.base.model;


import java.util.List;

/**
 * @ClassName: PageBean
 * @Description 分页Bean
 * @author: Shawn Wu
 * @date: 2019/5/5 14:43
 * @version:
 */
public class PageBean<T> {

    /**
     * 当前页码（默认为第一页）
     */
    private Integer pageNo = 1;
    /**
     * 每页显示的条数（默认每页10条）
     */
    private Integer pageSize = 10;
    /**
     * 总条数
     */
    private Integer totalNum;
    /**
     * 是否有下一页
     */
    private Boolean isMore;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 开始索引
     */
    private Integer startIndex;
    /**
     * 分页结果
     */
    private List<T> records;

    public PageBean(){
        super();
    }

    public PageBean(Integer pageNo, Integer pageSize){
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.startIndex = (this.pageNo - 1) * this.pageSize + 1;
        this.isMore = (this.pageNo >= this.totalPage)?false:true;
    }

    public PageBean(Integer pageNo, Integer pageSize, Integer totalNum){
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.startIndex = (this.pageNo - 1) * this.pageSize + 1;
        this.isMore = (this.pageNo >= this.totalPage)?false:true;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalPage = (totalNum + this.pageSize - 1) / this.pageSize;
        this.isMore = (this.pageNo >= this.totalPage)?false:true;
        this.startIndex = (this.pageNo - 1) * this.pageSize + 1;
        this.totalNum = totalNum;
    }

    public Boolean getIsMore() {
        return isMore;
    }

    public void setIsMore(Boolean isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}