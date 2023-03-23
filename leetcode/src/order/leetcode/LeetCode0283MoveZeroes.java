package order.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author tengxq
 */
public class LeetCode0283MoveZeroes {
    public static void main(String[] args) {
        LeetCode0283MoveZeroes solution = new LeetCode0283MoveZeroes();
        int[] nums = {0,1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int p = 0;
        int q = 0;
        int n = nums.length;
        while (q < n) {
            if (nums[q] != 0) {
                nums[p++] = nums[q];
            }
            q++;
        }
        while (p < n) {
            nums[p++] = 0;
        }

    }
}
