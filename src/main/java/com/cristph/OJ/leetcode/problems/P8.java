package com.cristph.OJ.leetcode.problems;

public class P8 {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String tmp = str.trim();
        int len = tmp.length();
        if (len == 0) {
            return 0;
        }
        char[] array = tmp.toCharArray();
        int i = 0;
        if ((array[i] < '0' || array[i] > '9') && (array[i] != '-' && array[i] != '+')) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(len - i + 1);
        boolean negative = false;
        if (array[i] == '-' || array[i] == '+') {
            stringBuilder.append(array[i]);
            if (array[i] == '-') negative = true;
            i++;
        }
        while (i < array.length && array[i] >= '0' && array[i] <= '9') {
            stringBuilder.append(array[i++]);
        }
        tmp = stringBuilder.toString();
        int result = 0;
        try {
            result = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            if (tmp.equals("+") || tmp.equals("-")) {
                return 0;
            }
            if (negative) result = Integer.MIN_VALUE;
            else result = Integer.MAX_VALUE;
        }
        return result;
    }
}
