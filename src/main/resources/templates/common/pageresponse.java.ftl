package ${chaiPackPath}.common1;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResponse<T extends Serializable> implements Serializable {
    /**
    * 当前页
    */
    private long pageNo;

    /**
    * 每页条数
    */
    private long pageSize;

    /**
    * 总页数
    */
    private long pageTotal;

    /**
    * 总条数
    */
    private long totalNum;

    /**
    * 集合的内容
    */
    private List<T> records;


        public PageResponse() {
        }

        public PageResponse(PageInfo<T> pageInfo) {
            this.pageNo = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.pageTotal = pageInfo.getPages();
            this.totalNum = pageInfo.getTotal();
            this.records = pageInfo.getList();
            }
}