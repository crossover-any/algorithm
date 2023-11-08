package order.leetcode;

import entity.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author tengxq
 */
public class LeetCode0226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightNode = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightNode);
        return root;
    }
}
