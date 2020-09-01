package com.elvis.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Elvis
 * @since : 2020/8/3 12:21
 */
@Data
@ApiModel(value = "TimeStr|时间字符串对象")
public class TimeStr implements Serializable {

    @ApiModelProperty("开始时间字符串")
    private String startTime;

    @ApiModelProperty("结束时间字符串")
    private String endTime;
}
