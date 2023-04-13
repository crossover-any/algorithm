package order.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 *
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 *
 * @author tengxq
 */
public class LeetCode2404MostFrequentEvenElement {

    /**
     * 思路：遍历数组，记录每个数字出现的次数到字典
     *      遍历字典获得最大次数的值，如果次数一样，取最小的
     * 时间复杂度 O（n）
     * 空间复杂度 O（n）
     * @param nums 数组
     * @return 出现次数最多的值
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                dic.put(num, dic.getOrDefault(num, 0) + 1);
            }
        }
        if (dic.isEmpty()) {
            return -1;
        }
        int maxCount = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            if (maxCount < entry.getValue() ) {
                maxCount = entry.getValue();
                maxValue = entry.getKey();
            } else if (maxCount == entry.getValue() && maxValue > entry.getKey()) {
                maxValue = entry.getKey();
            }
        }
        return maxValue;
    }
}
