package order.leetcode;

import java.util.Arrays;

/**
 * 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k个位置，其中k是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * @author tengxq
 */
public class LeetCode0189RotateArray {

    public static void main(String[] args) {
        LeetCode0189RotateArray solution = new LeetCode0189RotateArray();
        int[] nums = {1, 2, 3};
        solution.rotate3(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：模拟轮转
     * 时间复杂度 O（n*k）
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @param k    轮转K位
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            // 记录最后一个位置的值
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        // 求 K和nums.length的最小公倍数
        int cycleCount = gcd(nums.length, k);

        for (int start = 0; start < cycleCount; start++) {
            int i = start;
            int prev = nums[start];
            int temp;
            do {
                int next = (i + k) % nums.length;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                i = next;
            } while (i != start);
        }
    }

    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int a, int b) {
        if (a >= nums.length || b >= nums.length) {
            return;
        }
        int temp;
        while (a < b) {
            temp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = temp;
        }
    }

    /**
     * 求最大公约数
     *
     * @param a 值1
     * @param b 值2
     * @return 最大公约数
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return 0;
        }
        int c = a % b;
        return c == 0 ? b : gcd(b, c);
    }
}
