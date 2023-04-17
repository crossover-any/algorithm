package order.leetcode;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 *
 * @author tengxq
 */
public class LeetCode0169MajorityElement {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
