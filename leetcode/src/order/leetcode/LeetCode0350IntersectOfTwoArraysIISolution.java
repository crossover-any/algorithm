package order.leetcode;

import java.util.*;

/**
 * 两个数组的交集 II
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致
 * （如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *
 * @author tengxq
 */
public class LeetCode0350IntersectOfTwoArraysIISolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：
     *      1.初始化nums1为map{value, counter(出现次数)}字典形式
     *      2.遍历nums2如果包含当前value并且counter大于0则符合查找条件
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Map<Integer, Integer> dic = new HashMap<>(nums1.length);
        for (int num : nums1) {
            Integer counter = dic.getOrDefault(num, 0);
            dic.put(num, counter + 1);
        }
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (dic.containsKey(num)) {
                Integer counter = dic.get(num);
                if (counter > 0) {
                    arr[index++] = num;
                    dic.put(num, counter -1);
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    /**
     * 思路：
     *      1.使用快排分别把两个数组从小到大（从大到小）排列
     *      2.遍历两数组进行比较
     *
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(logn)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        // 这里集合需要比较上一个的值就直接初始化一个数组
        int index = 0;
        // 取最小是为了节约空间，多申请一个空间的目的是使用index=0的位置减少if判断
        int[] arr = new int[(Math.min(nums1.length, nums2.length)) + 1];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                // 相对于349题这里我们不再需要去重，直接把if判断去掉即可
                arr[++index] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(arr, 1, index + 1);
    }

    /**
     * 思路：
     *      1.使用快排分别把两个数组从小到大（从大到小）排列
     *      2.遍历两数组进行比较
     *
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(logn)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        // 这里集合需要比较上一个的值就直接初始化一个数组
        int index = 0;
        // 取最小是为了节约空间，这里不再需要去重，index指向尾部元素的下一个位置下标，不用多申请一个空间
        int[] arr = new int[Math.min(nums1.length, nums2.length)];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                // 这里的index指向的数组中的尾部元素的下一个位置下标
                arr[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }
}
