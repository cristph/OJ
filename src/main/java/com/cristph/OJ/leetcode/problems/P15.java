package com.cristph.OJ.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int i = 0, p = 1, q = nums.length - 1;
        while (i < nums.length - 2 && nums[i] < 1 && p < q) {
            int reverse = -nums[i];
            int tmp = nums[p] + nums[q];
            if (tmp == reverse) {
                lists.add(Arrays.asList(nums[i], nums[p], nums[q]));
                while (p + 1 < q && nums[p + 1] == nums[p]) {
                    p++;
                }
                p++;
                q--;
            } else if (tmp > reverse) {
                q--;
            } else {
                while (p + 1 < q && nums[p + 1] == nums[p]) {
                    p++;
                }
                p++;
            }

        }
        return lists;
    }
}
