package com.cn.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RawPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence password) {
        return password.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodePassword) {
        return rawPassword.equals(encodePassword);
    }
}