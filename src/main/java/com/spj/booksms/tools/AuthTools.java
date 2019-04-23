package com.spj.booksms.tools;

public class AuthTools {
    public static boolean isNullOrSpace(String str) {
        return null == str || "".equals(str) ? true : false;
    }
}
