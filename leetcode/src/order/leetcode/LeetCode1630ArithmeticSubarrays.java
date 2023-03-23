package order.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 等差子数组
 *
 * 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * 输出：[true,false,true]
 * 解释：
 * 第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
 * 第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
 * 第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。
 *
 *
 * @author tengxq
 */
public class LeetCode1630ArithmeticSubarrays {

    public static void main(String[] args) {
        LeetCode1630ArithmeticSubarrays solution = new LeetCode1630ArithmeticSubarrays();
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        solution.checkArithmeticSubarrays(nums, l ,r);
    }


    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>(l.length);
        int[] arrays = new int[nums.length];
        int index;
        for (int i = 0; i < l.length; i++) {
            index = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                arrays[index++] = nums[j];
            }
            list.add(isArithmeticArrays(arrays, index));
        }
        return list;
    }

    public boolean isArithmeticArrays(int[] nums, int length) {
        if (nums.length < 3) {
            return true;
        }
        Arrays.sort(nums, 0, length);
        int subValue = nums[1] - nums[0];
        for (int i = 2; i < length; i++) {
            if (subValue != nums[i] - nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
