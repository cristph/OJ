package com.cristph.OJ.leetcode;

import com.cristph.OJ.common.ListNode;

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int add_bit = 0;
        ListNode node = new ListNode(0);
        ListNode tmp_head = node;
        while (head1 != null && head2 != null) {
            int v = head1.val + head2.val + add_bit;
            if (v > 9) {
                v = v - 10;
                add_bit = 1;
            } else {
                add_bit = 0;
            }
            node.next = new ListNode(v);
            node = node.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        ListNode left = null;
        if (head1 != null) {
            left = head1;
        } else if (head2 != null) {
            left = head2;
        }
        if (left == null && add_bit == 1) {
            node.next = new ListNode(1);
        } else if (left != null) {
            while (left != null) {
                int v = left.val + add_bit;
                if (v > 9) {
                    v = v - 10;
                    add_bit = 1;
                } else {
                    add_bit = 0;
                }
                node.next = new ListNode(v);
                node = node.next;
                left = left.next;
            }
            if (add_bit == 1) {
                node.next = new ListNode(1);
            }
        }
        ListNode head = tmp_head.next;
        tmp_head.next = null;
        return head;
    }

    private ListNode inverse(ListNode head) {
        ListNode p = head;
        ListNode q = p.next;
        ListNode tmp = q.next;
        while (q != null) {
            q.next = p;
            p = q;
            q = tmp;
            tmp = q.next;
        }
        return p;
    }

    public String getVal(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            stringBuilder.append(p.val);
            p = p.next;

        }
        return stringBuilder.toString();
    }
}
