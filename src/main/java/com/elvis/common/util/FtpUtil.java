package com.elvis.common.util;

import com.elvis.common.prop.FtpProp;

/**
 * @author : Elvis
 * @since : 2020/8/28 17:37
 */
public class FtpUtil {
    private FtpUtil() {
    }

    private FtpProp ftpProp;

    public FtpUtil newInstance(FtpProp ftpProp) {
        this.ftpProp = ftpProp;
        return this;
    }


}
