package order._217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * @author tengxq
 */
public class ContainsDuplicateSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        ContainsDuplicateSolution containsDuplicateSolution = new ContainsDuplicateSolution();
        System.out.println(containsDuplicateSolution.containsDuplicate3(null));
    }


    /**
     * 思路：
     *      根据set.add的特性
     *      如果集合没有该值添加成功并返回false
     *      如果集合已存在该值返回false
     *  时间复杂度O(n)
     *  空间复杂度O(n)
     * @param nums 数组
     * @return 是否存在重复元素
     */
    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> dic = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!dic.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路：
     *      1. 先快排对数组进行排序
     *      2. 如果紧邻两个元素相等，则包含重复元素
     *      时间复杂度O(NlogN), 空间复杂度(logN)
     * @param nums 数组
     * @return 是否存在重复元素
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路：
     * 利用Java的Stream流工具，但是效率低，不建议
     *
     * @param nums 数组
     * @return 是否存在重复元素
     */
    public boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        return IntStream.of(nums).distinct().count() < nums.length;
    }

}
