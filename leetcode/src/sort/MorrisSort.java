package sort;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/384818393?utm_id=0
 * 莫里斯树遍历算法
 *
 * @author tengxq
 */
public class MorrisSort {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            TreeNode p1 = root;
            TreeNode p2 = null;
            while (p1 != null) {
                p2 = p1.left;
                if (p2 != null) {
                    //找到左子树的最右叶子节点
                    while (p2.right != null && p2.right != p1) {
                        p2 = p2.right;
                    }
                    //添加 right 指针，对应 right 指针为 null 的情况
                    if (p2.right == null) {
                        list.add(p1.val);
                        p2.right = p1;
                        p1 = p1.left;
                        continue;
                    }
                    //对应 right 指针存在的情况，则去掉 right 指针
                    p2.right = null;
                } else {
                    list.add(p1.val);
                }
                //移动 p1
                p1 = p1.right;
            }
            return list;
        }
}
