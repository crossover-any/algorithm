package order.leetcode;

import entity.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author tengxq
 */
public class LeetCode0019RemoveNthFromEnd {

    /**
     * 思路 快慢指针
     * 首先将快指针向后移动 n 步，然后再一起移动
     * 当快指针到达末尾，慢指针到达倒数的第 n+1个节点
     * @param head 头结点
     * @param n 倒数
     * @return 新链表
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 移动n步
        for (int i = 0; i < n && fast.next != null; i++) {
            fast = fast.next;
        }
        // 同时移动
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 移除倒数第n个节点
        slow.next = slow.next.next;
        return dummyHead.next;
    }


    /**
     * 思路 利用递归
     * @param head 头结点
     * @param n 倒数
     * @return 新链表
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        recursion(dummy, n);
        return dummy.next;
    }

    public int recursion(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int v = recursion(head.next, n);
        if (v == n) {
            head.next = head.next.next;
        }
        return v+1;
    }


}
