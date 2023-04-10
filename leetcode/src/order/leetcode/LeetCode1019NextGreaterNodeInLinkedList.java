package order.leetcode;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 链表中的下一个更大节点
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0。
 *
 *
 * @author tengxq
 */
public class LeetCode1019NextGreaterNodeInLinkedList {

    private int[] ans;
    private Deque<Integer> stack = new LinkedList<>();
    public int[] nextLargerNodes(ListNode head) {
        dfs(head, 0);
        return ans;
    }

    public void dfs(ListNode root, int i) {
        if (root == null) {
            ans = new int[i];
            return;
        }
        dfs(root.next, i +1);
        while (!stack.isEmpty() && root.val > stack.peek()) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            ans[i] = stack.peek();
        }
        stack.push(root.val);
    }

    public int[] nextLargerNodes2(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next)
            ++n; // 确定返回值的长度
        ans = new int[n];
        Deque<Integer[]> st = new ArrayDeque<>(); // 单调栈（节点值，节点下标）
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!st.isEmpty() && st.peek()[0] < cur.val)
                ans[st.pop()[1]] = cur.val; // 用当前节点值更新答案
            st.push(new Integer[]{cur.val, i++});
        }
        return  ans;
    }
}
