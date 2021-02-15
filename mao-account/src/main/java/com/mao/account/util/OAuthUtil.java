package com.mao.account.util;

import com.mao.common.entity.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * OAuth2 工具类
 * @author : create by zongx at 2020/10/16 14:13
 */
public class OAuthUtil {

    private static final Logger LOG = LoggerFactory.getLogger(OAuthUtil.class);

    public static Operator getOperator() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
            String username = oAuth2Authentication.getUserAuthentication().getName();
            String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
            return new Operator(clientId, username);
        } catch (Exception e) {
            LOG.warn("未在OAuth2中找到客户端与用户信息！");
            return new Operator();
        }
    }

}
