package order.leetcode;

import entity.ListNode;

import java.util.*;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCodeOffer06ReversePrint {

    public static void main(String[] args) {
        LeetCodeOffer06ReversePrint solution = new LeetCodeOffer06ReversePrint();
        ListNode head = new ListNode();
        head.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 3;
        ListNode node3 = new ListNode();
        node3.val = 2;
        head.next = node2;
        node2.next = node3;
        solution.reversePrint(head);
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        recursion(head, res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void recursion(ListNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recursion(node.next, res);
        res.add(node.val);
    }
}
