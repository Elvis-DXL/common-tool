package com.elvis.common.prop;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : Elvis
 * @since : 2020/8/28 17:37
 */
@Data
@ToString
public class EmailProp implements Serializable {
    @ApiModelProperty("服务器")
    private String host;
    @ApiModelProperty("端口")
    private String port;
    @ApiModelProperty("协议")
    private String protocol;
    @ApiModelProperty("发送人邮件地址")
    private String userName;
    @ApiModelProperty("发送人邮件密码/授权码")
    private String password;
    @ApiModelProperty("邮件发送人名称")
    private String name;
}
