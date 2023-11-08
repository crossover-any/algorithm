package order.leetcode;

import entity.TreeNode;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCode0104MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxDepth = Math.max(leftDepth, rightDepth);
        return maxDepth + 1;
    }
}
