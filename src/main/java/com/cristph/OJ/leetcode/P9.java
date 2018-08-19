package com.cristph.OJ.leetcode;

public class P9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 9) {
            return true;
        }
        int len = 0;
        int[] array = new int[10];
        while (x / 10 > 0) {
            array[len] = x % 10;
            len++;
            x = x / 10;
        }
        array[len] = x;
        int i = 0, j = len;
        while (i < j) {
            if (array[i] == array[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
