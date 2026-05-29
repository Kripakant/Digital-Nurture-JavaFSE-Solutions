package com.greetings;

import com.utils.StringUtils;

// Entry point for the com.greetings module; uses the com.utils module.
public class Main {
    public static void main(String[] args) {
        String message = "hello from modules";
        System.out.println(StringUtils.toUpper(message));
        System.out.println(StringUtils.repeat("=", 20));
        System.out.println("com.greetings successfully used com.utils!");
    }
}
