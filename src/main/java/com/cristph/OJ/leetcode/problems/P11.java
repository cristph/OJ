package com.cristph.OJ.leetcode.problems;

public class P11 {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, h = height.length - 1, max = 0;
        while (l < h) {
            max = Math.max(max, (h - l) * Math.min(height[l], height[h]));
            if (height[l] < height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return max;
    }
}
