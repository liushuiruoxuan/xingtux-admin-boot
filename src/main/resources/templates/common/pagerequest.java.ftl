package ${chaiPackPath}.common1;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class PageRequest<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -7391097880029846491L;
    private static int DEFAULT_PAGE_SIZE = 20;
    private static int DEFAULT_MAX_SIZE = 200;
    private int pageNum = 1;
    private int pageSize = 20;
    private T paramData;

    public PageRequest() {
    }

    public PageRequest(int pageNum, int pageSize) {
    int pageNumTemp = pageNum <= 0 ? 1 : pageNum;
    int pageSizeTemp = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    if (pageSizeTemp > DEFAULT_MAX_SIZE) {
    pageSizeTemp = DEFAULT_MAX_SIZE;
    }

    this.pageNum = pageNumTemp;
    this.pageSize = pageSizeTemp;
    }

    public int getPageNum() {
    return this.pageNum;
    }

    public void setPageNum(int pageNum) {
    int pageNumTemp = pageNum <= 0 ? 1 : pageNum;
    this.pageNum = pageNumTemp;
    }

    public int getPageSize() {
    return this.pageSize;
    }

    public void setPageSize(int pageSize) {
    int pageSizeTemp = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    if (pageSizeTemp > DEFAULT_MAX_SIZE) {
    pageSizeTemp = DEFAULT_MAX_SIZE;
    }

    this.pageSize = pageSizeTemp;
    }

    public String toString() {
    return JSON.toJSONString(this);
    }

    public T getParamData() {
    return this.paramData;
    }

    public void setParamData(T paramData) {
    this.paramData = paramData;
    }
}