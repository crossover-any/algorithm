package order.leetcode;

import entity.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * <p>
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *
 * @author tengxq
 */
public class LeetCode0876MiddleNode {

    /**
     * 思路：快慢指针
     * 使用一对快慢指针，快指针一次前进两部，慢指针移动一步
     * 当快指针移动到末尾的时候，慢指针移动到中间的位置
     *
     * @param head 头指针
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast.next != null) {
            fast = fast.next;
            fast = fast.next;

            low = low.next;
            if (fast == null) {
                break;
            }
        }

        return low;
    }
}
