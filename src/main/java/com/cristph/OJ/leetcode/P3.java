package com.cristph.OJ.leetcode;

public class P3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxLen = 0;
        int[] index = new int[128];
        for (int i = 0, j=0; j < len; j++) {
            i = Math.max(index[s.charAt(j)], i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return maxLen;
    }
}
