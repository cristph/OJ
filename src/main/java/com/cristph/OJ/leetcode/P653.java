package com.cristph.OJ.leetcode;

import com.cristph.OJ.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P653 {

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val + node.val != k && search(root, k - node.val)) {
                return true;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    private boolean search(TreeNode root, int k) {
        if (root == null) return false;
        if (root.val == k) return true;
        else if (root.val < k) return search(root.right, k);
        else if (root.val > k) return search(root.left, k);
        return false;
    }
}
