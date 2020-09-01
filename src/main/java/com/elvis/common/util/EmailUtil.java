package com.elvis.common.util;

import com.elvis.common.prop.EmailProp;

/**
 * @author : Elvis
 * @since : 2020/8/28 17:37
 */
public class EmailUtil {
    private EmailUtil() {
    }

    private EmailProp emailProp;

    public EmailUtil newInstance(EmailProp emailProp) {
        this.emailProp = emailProp;
        return this;
    }


}
