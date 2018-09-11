package com.cristph.OJ.leetcode;


import com.cristph.OJ.common.ListNode;
import com.cristph.OJ.common.TreeNode;
import com.cristph.OJ.leetcode.problems.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestOJ {

    @Test
    public void TestP1() {
        P1 p1 = new P1();
        Assertions.assertArrayEquals(new int[]{0, 1}, p1.twoSum(new int[]{2, 7, 11, 5}, 9));
    }

    @Test
    public void TestP167() {
        P167 p167 = new P167();
        Assertions.assertArrayEquals(new int[]{1, 3}, p167.twoSum(new int[]{2, 5, 7, 11}, 9));
    }

    @Test
    public void Test653() {
        P653 p653 = new P653();
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))
        );
        Assertions.assertEquals(true, p653.findTarget(root, 12));
        Assertions.assertEquals(false, p653.findTarget(root, 14));
        Assertions.assertEquals(false, p653.findTarget(root, 15));

        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Assertions.assertEquals(true, p653.findTarget(root2, 4));

        TreeNode root3 = new TreeNode(0,
                new TreeNode(-1, new TreeNode(-3), null),
                new TreeNode(2, null, new TreeNode(4))
        );
        Assertions.assertEquals(true, p653.findTarget(root3, -4));
    }


    @Test
    public void Test2() {
        P2 p2 = new P2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Assertions.assertEquals("708", p2.getVal(p2.addTwoNumbers(l1, l2)));
    }

    @Test
    public void Test3() {
        P3 p3 = new P3();
        Assertions.assertEquals(3, p3.lengthOfLongestSubstring("abcccbcccaa"));
        Assertions.assertEquals(1, p3.lengthOfLongestSubstring("aaaaaa"));
    }

    @Test
    public void Test4() {

    }

    @Test
    public void Test5() {
        P5 p5 = new P5();
        Assertions.assertEquals("aaaaaa", p5.longestPalindrome("aaaaaa"));
        Assertions.assertTrue(p5.longestPalindrome("abacab").equals("abaca") || p5.longestPalindrome("abacab").equals("bacab"));
    }

    @Test
    public void Test6() {
        P6 p6 = new P6();
        Assertions.assertEquals("PAHNAPLSIIGYIR", p6.convert("PAYPALISHIRING", 3));
        Assertions.assertEquals("PINALSIGYAHRPI", p6.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void Test7() {
        P7 p7 = new P7();
        Assertions.assertEquals(0, p7.reverse(2147483647));
        Assertions.assertEquals(12, p7.reverse(21));
    }

    @Test
    public void Test8() {
        P8 p8 = new P8();
        Assertions.assertEquals(-42, p8.myAtoi("   -42"));
        Assertions.assertEquals(-2147483648, p8.myAtoi("-91283472332"));
        Assertions.assertEquals(0, p8.myAtoi("words and 987"));
        Assertions.assertEquals(4193, p8.myAtoi("4193 with words"));
    }

    @Test
    public void Test9() {
        P9 p9 = new P9();
        Assertions.assertEquals(true, p9.isPalindrome(11));
        Assertions.assertEquals(true, p9.isPalindrome(0));
        Assertions.assertEquals(true, p9.isPalindrome(121));
        Assertions.assertEquals(false, p9.isPalindrome(-121));
    }

    @Test
    public void Test10() {
        P10 p10 = new P10();
        Assertions.assertEquals(false, p10.isMatch("aa", "a"));
        Assertions.assertEquals(true, p10.isMatch("aa", "a*"));
        Assertions.assertEquals(true, p10.isMatch("ab", ".*"));
        Assertions.assertEquals(true, p10.isMatch("abc", ".*c"));
        Assertions.assertEquals(false, p10.isMatch("abcd", ".*cdd"));
        Assertions.assertEquals(true, p10.isMatch("aab", "c*a*b"));
        Assertions.assertEquals(false, p10.isMatch("mississippi", "mis*is*p*."));
        Assertions.assertEquals(true, p10.isMatch("a", "ab*"));


        HashMap map = new HashMap<>();
        map.put("", "");
    }


    @Test
    public void Test11() {
        P11 p11 = new P11();
        Assertions.assertEquals(49, p11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    public void Test14() {
        P14 p14 = new P14();
        Assertions.assertEquals("fl", p14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assertions.assertEquals("a", p14.longestCommonPrefix(new String[]{"aa", "a"}));
    }
}
