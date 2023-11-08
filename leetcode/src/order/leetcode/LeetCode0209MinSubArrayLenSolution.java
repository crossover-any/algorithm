package order.leetcode;

/**
 * 给定一个含n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * @author tengxq
 */
public class LeetCode0209MinSubArrayLenSolution {

    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int subLength;
        int head = 0;
        for (int tail = 0; tail < nums.length; tail++) {
            sum += nums[tail];
            while (sum >= target) {
                subLength = (tail -  head) + 1;
                result = Math.min(result, subLength);
                sum-=nums[head++];
            }
        }
        return result == Integer.MAX_VALUE? 0: result;
    }
}
