package com.cristph.OJ.leetcode.problems;


import java.util.HashMap;
import java.util.HashSet;

public class P1 {

    // 暴力法
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //hash 空间换时间
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
