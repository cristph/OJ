package com.cristph.OJ.leetcode;


import com.cristph.OJ.common.ListNode;
import com.cristph.OJ.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void Test2(){
        P2 p2=new P2();
        ListNode l1=new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2=new ListNode(5, new ListNode(6, new ListNode(4)));
        Assertions.assertEquals("708", p2.getVal(p2.addTwoNumbers(l1, l2)));
    }

    @Test
    public void Test3(){
        P3 p3=new P3();
        Assertions.assertEquals(3, p3.lengthOfLongestSubstring("abcccbcccaa"));
        Assertions.assertEquals(1, p3.lengthOfLongestSubstring("aaaaaa"));
    }
}
