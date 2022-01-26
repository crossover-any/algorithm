package order._1;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target
 * 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author tengxq
 */
public class TwoSumSolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：暴力破解，枚举每一种可能出现的情况
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     *
     * @param nums   数组
     * @param target 目标值
     * @return 两数组成的数组
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * 思路：建立数据字典{值，数组下标}，如果字典中有期望的值，则查找成功
     * 例如：target = 10, 遍历到值为 1 的时候，期望的值是 9，
     * 如果字典中有9那么查找成功。
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param nums   数组
     * @param target 目标值
     * @return 两数下标组成的数组
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer otherIndex = dic.get(target - nums[i]);
            if (otherIndex != null) {
                return new int[]{otherIndex, i};
            }
            dic.put(nums[i], i);
        }
        throw new NoSuchElementException();
    }

}
