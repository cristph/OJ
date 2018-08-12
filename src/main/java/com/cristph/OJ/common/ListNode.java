package com.cristph.OJ.common;

import lombok.Data;

@Data
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
