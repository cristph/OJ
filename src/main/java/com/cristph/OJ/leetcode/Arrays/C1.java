package com.cristph.OJ.leetcode.Arrays;

public class C1 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (nums != null && len > 1) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    nums[i - count] = nums[i];
                }
            }
            for (int i = len - count; i < len; i++) {
                nums[i] = 0;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int i = -1, j = 0, len = nums.length;
        while (j < nums.length) {
            while (j + 1 < len && nums[j + 1] == nums[j]) j++;
            nums[++i] = nums[j++];
        }
        return i + 1;
    }

    public void sortColors(int[] nums) {
        int i = 0, left = -1, right = nums.length;
        while (i < right) {
            if (nums[i] < 1) swap(nums, ++left, i++);
            else if (nums[i] > 1) swap(nums, i, --right);
            else i++;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args) {
        C1 c1 = new C1();
        int result = c1.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(result);
        int res = c1.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);
    }

}
