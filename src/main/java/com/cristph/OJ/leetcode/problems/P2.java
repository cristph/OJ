package com.cristph.OJ.leetcode.problems;

import com.cristph.OJ.common.ListNode;

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, r = new ListNode(0), h = r;
        int carry = 0, sum = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            sum = x + y + carry;
            carry = sum / 10;
            h.next = new ListNode(sum % 10);
            h = h.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) h.next = new ListNode(carry);
        return r.next;
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
