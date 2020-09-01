package com.elvis.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : Elvis
 * @since : 2020/6/28 13:57
 */
@Data
@ApiModel(value = "PageTimeDTO|分页时间查询入参")
public class PageTimeDTO extends PageDTO implements Serializable {

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;
}
