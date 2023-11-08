package order.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部
 *
 * @author tengxq
 */
public class LeetCode0053MaximumSubarrySolution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        LeetCode0053MaximumSubarrySolution maxSubArraySolution = new LeetCode0053MaximumSubarrySolution();
        maxSubArraySolution.maxSubArray1(nums);
    }

    /**
     * 思路：假设最大子数组和是从第i个位置开始，我们只需要遍历每个以i位置开始的连续元素的最大和
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubArray1(int[] nums) {
        int maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i; j < nums.length; j++) {
                max += nums[j];
                if (maxSub < max) {
                    maxSub = max;
                }
            }
        }
        return maxSub;
    }

    /**
     * 思路：同样的将问题分割最小
     *       假设只有一个数，那么我们的最大子数组和就是第一个数（maxSub=nums[0]）
     *       如果有第二个数，我们将第一个数加上第二个数的和与第一个数进行比较
     *       如果比第一个数的和要大，那么我们可以将第二个数收入囊中
     *           反之说明第一个数是目前为止找到最大的子数组，但是我们还得继续找下去
     *           将目前最大值记录下来，设置最大和为第二个元素以第二个元素为起点继续查找
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubArray2(int[] nums) {
        int maxSub = nums[0];
        int pres = maxSub;

        for (int i = 1; i < nums.length; i++) {
            int next = pres + nums[i];
            pres = Math.max(nums[i], next);
            if (pres > maxSub) {
                maxSub = pres;
            }
        }
        return maxSub;
    }
}
