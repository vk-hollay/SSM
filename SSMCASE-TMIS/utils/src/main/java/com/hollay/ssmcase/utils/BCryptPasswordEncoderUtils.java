package com.hollay.ssmcase.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hollay
 * @create 2021-03-11-13:56
 * @description 密码加密处理
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123456";
        String pwd = BCryptPasswordEncoderUtils.encodePassword(password);
        System.out.println(pwd);//加密结果：$2a$10$pKguo93pGZRj1KvnGXjDquzBlxQto30cq8224zScz3VEtRy4NEkMG（每次都不一样）
    }
}
