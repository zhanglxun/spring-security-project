package com.sense.provider.auth.security;

//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * 密码的加密管理
// */
//public class SensePasswordEncoder implements PasswordEncoder {
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return rawPassword.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        //先使用encode 加密策略加密，在进行对比
//        return encode(rawPassword).equals(encodedPassword);
//    }
//
//}
