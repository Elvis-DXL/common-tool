package com.elvis.common.util;

import com.elvis.common.prop.FtpProp;

/**
 * @author : Elvis
 * @since : 2020/8/28 17:37
 */
public class FtpUtil {
    private FtpUtil(FtpProp ftpProp) {
        this.ftpProp = ftpProp;
    }

    private FtpProp ftpProp;

    private static FtpUtil ftpUtil;

    public static FtpUtil getInstance(FtpProp ftpProp) {
        if (null == ftpUtil) {
            synchronized (FtpUtil.class) {
                if (null == ftpUtil) {
                    ftpUtil = new FtpUtil(ftpProp);
                }
            }
        }
        return ftpUtil;
    }


}
