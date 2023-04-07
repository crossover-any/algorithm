package order.leetcode;

import java.util.Arrays;

/**
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 *
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 *
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 *
 *
 * @author tengxq
 */
public class LeetCode1053PreviousPermutationWithOneSwap {

    /**
     * 思路：观察可知，要想得到小于arr的最大排列的关键是找到，
     *      仅次于数组中的第二位数字大小的数字，如果没有，则找小于第3位的，依次类推
     * @param arr 带交换排列数组
     * @return 排列过后的数组
     */
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length -1 ; j > i ; j--) {
                if (findTheSecondMaxNumberAndSwap(arr, i, j)) {
                    return arr;
                }
            }
        }
        return arr;
    }

    public boolean findTheSecondMaxNumberAndSwap(int[] arr, int left, int right) {
        for (int i = right -1; i >= left; i--) {
            // 寻找第二大的数字，并且交换
            if (arr[i] == arr[right]) {
                right = i;
            }
            if (arr[i] > arr[right]) {
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1053PreviousPermutationWithOneSwap solution = new LeetCode1053PreviousPermutationWithOneSwap();
        System.out.println(Arrays.toString(solution.prevPermOpt1(new int[]{5,3,1,1,3})));
    }
    /**
     * 分析，仅次于当前排列的排列，
     * 最理想的排列是，倒数第一位和倒数第二位的数字交换
     *
     */
}
