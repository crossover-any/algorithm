package order._704;

/**
 * 二分查找
 *给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * @author tengxq
 */
public class BinarySearchSolution {

    public int search1(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid;
        while (low < high) {
            mid = low + ((high-low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid;
        while (low < high) {
            mid = low + ((high-low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
