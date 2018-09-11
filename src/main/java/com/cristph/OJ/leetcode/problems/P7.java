package com.cristph.OJ.leetcode.problems;

public class P7 {

    public int reverse(int x) {
        boolean sign = x < 0;
        if (sign) x = -x;
        String tmp = String.valueOf(x);
        tmp = new StringBuilder(tmp).reverse().toString();
        if (sign) tmp = "-" + tmp;
        int result = 0;
        try {
            result = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }
}
