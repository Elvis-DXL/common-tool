package com.elvis.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Elvis
 * @since : 2020/6/28 13:53
 */
@Data
@ApiModel(value = "PageDTO|分页查询入参")
public class PageDTO implements Serializable {

    @ApiModelProperty("页码")
    private Integer page;

    @ApiModelProperty("每页条数")
    private Integer limit;

    @ApiModelProperty("查询关键字")
    private String searchKey;

    @ApiModelProperty("排序方式")
    private String orderBy;
}
