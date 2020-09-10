package com.succulent.user.common;

import java.util.Random;

public class RandomUtil {

    private static String randomStrContent   = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static String randomLowerCaseStr = "qwertyuiopasdfghjklzxcvbnm1234567890";

    /// 生成随机字符串
    private static String getRandomStr(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int number = random.nextInt(randomStrContent.length() - 1);
            stringBuilder.append(randomStrContent.charAt(number));
        }
        return stringBuilder.toString();
    }
    /// 生成根据content内容的随机字符串
    private static String getRandomStrBy(String content, int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int number = random.nextInt(content.length() - 1);
            stringBuilder.append(content.charAt(number));
        }
        return stringBuilder.toString();
    }

    public static String genToken() {
        return getRandomStrBy(randomLowerCaseStr, 32);
    }

    /// 生成对象id
    public static String genObjectId() {
        return  getRandomStrBy(randomLowerCaseStr, 32);
    }


}
