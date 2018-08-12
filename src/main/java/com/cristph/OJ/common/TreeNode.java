package com.cristph.OJ.common;

import lombok.Data;

@Data
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
    }

}
