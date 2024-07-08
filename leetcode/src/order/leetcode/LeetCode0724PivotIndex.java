package order.leetcode;

/**
 * 724. 寻找数组的中心下标
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * @author tengxq
 */
public class LeetCode0724PivotIndex {

    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        int p = 0;
        int q = nums.length-1;
        while (p < q) {
            if (leftSum < rightSum) {
                leftSum += nums[q--];
            } else if (leftSum > rightSum){
                rightSum += nums[p++];
            } else {
                leftSum += nums[q--];
                rightSum += nums[p++];
            }
        }
        return rightSum == leftSum? p: -1;
    }
}
