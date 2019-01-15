package com.cn.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtAcctokenConverter implements JwtAccessTokenConverterConfigurer {
    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setSigningKey("12345");
    }
}
