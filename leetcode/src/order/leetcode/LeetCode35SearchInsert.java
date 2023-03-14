package order.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * @author tengxq
 */
public class LeetCode35SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = (left +right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                if (mid + 1 < right && target > nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    return mid + 1;
                }
            }
        }
        return 0;
    }
}
