package com.cristph.OJ.leetcode.problems;

public class P14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }

        int minStrLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minStrLen = Math.min(minStrLen, strs[i].length());
        }
        int p = 0;
        for (; p < minStrLen; p++) {
            char c = strs[0].charAt(p);
            for (int i = 1; i < len; i++) {
                if (c != strs[i].charAt(p)) {
                    return strs[0].substring(0, p);
                }
            }
        }
        return strs[0].substring(0, p);
    }
}
