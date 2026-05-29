package com.utils;

// A simple utility class exported by the com.utils module.
public class StringUtils {

    public static String toUpper(String input) {
        return input == null ? null : input.toUpperCase();
    }

    public static String repeat(String input, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(input);
        }
        return sb.toString();
    }
}
