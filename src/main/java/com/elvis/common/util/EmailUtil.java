package com.elvis.common.util;

import com.elvis.common.prop.EmailProp;

/**
 * @author : Elvis
 * @since : 2020/8/28 17:37
 */
public class EmailUtil {
    private EmailUtil(EmailProp emailProp) {
        this.emailProp = emailProp;
    }

    private EmailProp emailProp;

    private static EmailUtil emailUtil;

    public static EmailUtil newInstance(EmailProp emailProp) {
        if (null == emailUtil) {
            synchronized (EmailUtil.class) {
                if (null == emailUtil) {
                    emailUtil = new EmailUtil(emailProp);
                }
            }
        }
        return emailUtil;
    }


}
