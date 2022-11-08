package com.gjq.generator.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;


/**
 * @Author: gjq
 * @Description:MD5加密工具类
 * @Date: 2022/11/8  11:17
 */

@Component
public class MD5Utils {
    public static String slat = "1a2b3c4d";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFromPass(String inputPass) {
        String str = slat.charAt(0) + slat.charAt(3) + inputPass + slat.charAt(2) + slat.charAt(6);
        return DigestUtils.md5Hex(str);
    }

    public static String fromPassToBasePass(String fromPass, String slat) {
        String str = slat.charAt(0) + slat.charAt(3) + fromPass + slat.charAt(2) + slat.charAt(6);
        return DigestUtils.md5Hex(str);
    }

    public static String inputPassToBasePass(String inputPass,String slat){
        String fromPass = inputPassToFromPass(inputPass);
        String bassPass = fromPassToBasePass(fromPass, slat);
        return bassPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        //37c71fd3c5591b4a75da1db3a5ac6d3b
        System.out.println(fromPassToBasePass("37c71fd3c5591b4a75da1db3a5ac6d3b","1a2b33c4d"));
    }
}
