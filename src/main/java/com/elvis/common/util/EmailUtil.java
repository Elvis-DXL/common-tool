package com.elvis.common.util;

import com.elvis.common.prop.EmailProp;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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

    public static EmailUtil getInstance(EmailProp emailProp) {
        if (null == emailUtil) {
            synchronized (EmailUtil.class) {
                if (null == emailUtil) {
                    if (emailProp == null || StringUtil.isEmpty(emailProp.getUsername()) || StringUtil.isEmpty(emailProp.getPassword())
                            || StringUtil.isEmpty(emailProp.getProtocol()) || StringUtil.isEmpty(emailProp.getHost())
                            || StringUtil.isEmpty(emailProp.getPort())) {
                        throw new IllegalArgumentException("Configuration information error[" + emailProp.toString() + "]");
                    }
                    emailUtil = new EmailUtil(emailProp);
                }
            }
        }
        return emailUtil;
    }

    /**
     * 发送邮件
     *
     * @param title       标题
     * @param msg         内容
     * @param targetEmail 目标邮箱地址
     */
    public void sendEmail(String title, String msg, String... targetEmail) throws EmailException {
        if (StringUtil.isEmpty(title) || StringUtil.isEmpty(msg) || null == targetEmail || targetEmail.length == 0) {
            throw new IllegalArgumentException("Missing parameters[title=" + title + ";msg=" + msg + ";targetEmail=" + targetEmail);
        }
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setSSLOnConnect(true);
        simpleEmail.setHostName(emailProp.getHost());
        simpleEmail.setSslSmtpPort(emailProp.getPort());
        simpleEmail.setAuthentication(emailProp.getUsername(), emailProp.getPassword());
        simpleEmail.setFrom(emailProp.getUsername(), emailProp.getName());
        simpleEmail.setCharset("UTF-8");
        simpleEmail.addTo(targetEmail);
        simpleEmail.setSubject(title);
        simpleEmail.setMsg(msg);
        simpleEmail.send();
    }

}
