package com.elvis.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Elvis
 * @since : 2020/9/21 15:01
 */
@Data
@ApiModel(value = "ManualPage|手动分页对象")
public class ManualPage<T> implements Serializable {
    @ApiModelProperty("页码")
    private int pageNum;
    @ApiModelProperty("每页条数")
    private int pageSize;
    @ApiModelProperty("总条数")
    private int totalNum;
    @ApiModelProperty("总页数")
    private int totalPage;
    @ApiModelProperty("分页后的数据")
    private List<T> pageData;

    private ManualPage() {
    }

    public static <T> ManualPage manualPage(List<T> data, int pageNum, int pageSize) {
        ManualPage result = new ManualPage();
        if (null == data || data.size() == 0) {
            result.setPageNum(1);
            result.setPageSize(pageSize);
            result.setTotalNum(0);
            result.setTotalPage(0);
            result.setPageData(new ArrayList());
            return result;
        }
        result.setTotalNum(data.size());
        if (pageSize > result.getTotalNum()) {
            result.setPageNum(1);
            result.setPageSize(pageSize);
            result.setTotalPage(1);
            result.setPageData(data);
            return result;
        }
        result.setPageSize(pageSize);
        int tempPageTotal = result.getTotalNum() / result.getPageSize();
        tempPageTotal = tempPageTotal + (result.getTotalNum() % result.getPageSize() == 0 ? 0 : 1);
        result.setTotalPage(tempPageTotal);
        result.setPageNum(pageNum);
        if (result.getPageNum() > result.getTotalPage()) {
            result.setPageNum(1);
        }
        int fromIndex = (result.getPageNum() - 1) * result.getPageSize();
        int toIndex = result.getPageNum() * result.getPageSize() > result.getTotalNum() ? result.getTotalNum()
                : result.getPageNum() * result.getPageSize();
        result.setPageData(data.subList(fromIndex, toIndex));
        return result;
    }
}