package order.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 下一个更大的元素IV
 *
 * 给你一个下标从 0开始的非负整数数组nums。对于nums中每一个整数，你必须找到对应元素的第二大整数。
 *
 * 如果nums[j]满足以下条件，那么我们称它为nums[i]的第二大整数：
 *
 * j > i
 * nums[j] > nums[i]
 * 恰好存在 一个k满足 i < k < j且nums[k] > nums[i]。
 * 如果不存在nums[j]，那么第二大整数为-1。
 *
 * 比方说，数组[1, 2, 4, 3]中，1的第二大整数是4，2的第二大整数是3，3 和4的第二大整数是-1。
 * 请你返回一个整数数组answer，其中answer[i]是nums[i]的第二大整数。
 *
 *
 * @author tengxq
 */
public class LeetCode2454NextGreaterElementIV {

    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<int[]> stack1 = new LinkedList<>();
        Deque<int[]> stack2 = new LinkedList<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!stack2.isEmpty() && nums[i] > stack2.peekLast()[0]) {
                ans[stack2.remove()[1]] = nums[i];
            }
            while (!stack1.isEmpty() && nums[i] > stack1.peek()[0]) {
                stack2.push(stack1.pop());
            }
            stack1.push(new int[]{nums[i], i});
        }
        return ans;
    }
}
