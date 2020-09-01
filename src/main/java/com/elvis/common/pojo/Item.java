package com.elvis.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Elvis
 * @since : 2020/6/28 10:47
 */
@Data
@ApiModel(value = "Item|项对象")
public class Item<T> implements Serializable {

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("值")
    private String value;

    @ApiModelProperty("对象值")
    private T objValue;
}
