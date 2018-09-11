package com.cristph.OJ.leetcode.problems;

public class P5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        int len = s.length(), start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = getLongestPalindromeLen(s, len, i, i);
            int len2 = getLongestPalindromeLen(s, len, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLongestPalindromeLen(String str, int len, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
