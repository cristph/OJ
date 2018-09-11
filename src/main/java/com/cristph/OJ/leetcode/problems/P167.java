package com.cristph.OJ.leetcode.problems;

public class P167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] == target) return new int[]{i+1, j+1};
            else if (numbers[i] + numbers[j] > target) j--;
        }
        return null;
    }
}
