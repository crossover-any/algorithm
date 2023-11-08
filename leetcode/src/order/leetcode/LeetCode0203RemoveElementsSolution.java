package order.leetcode;

import entity.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @author tengxq
 */
public class LeetCode0203RemoveElementsSolution {

    /**
     * 根据程序逻辑进行分析有三种情况
     * 1.删除头结点
     * 2.删除中间节点
     * 3.删除尾部节点
     * 其中 2.3.可以合并一起处理，对于头结点如果单独处理比较麻烦，可以创建一个虚拟头结点，这样子可以统一逻辑处理
     * @param head 头结点
     * @param val 删除的节点值
     * @return 头结点
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = head;
        while (q != null) {
            if (q.val != val) {
                p.next = q;
                p = p.next;
            }
            q = q.next;
            p.next = null;
        }
       return dummyHead.next;
    }

    /**
     * 递归的方式，
     * 递归类似与方法1的区别是从后向前进行处理，这样的好处相当于加了个头结点，并且不用记录上一个节点的值
     * 根据栈的特性，先进后出，方便找到父节点。
     *
     * @param head 头结点
     * @param val 值
     * @return 新的链表头结点
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
