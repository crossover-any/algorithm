package order._349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author tengxq
 */
public class IntersectionOfTwoArraysSolution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        IntersectionOfTwoArraysSolution intersectionOfTwoArraysSolution = new IntersectionOfTwoArraysSolution();
        int[] intersection = intersectionOfTwoArraysSolution.intersection3(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    /**
     * 思路：穷举暴力破解
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        Set<Integer> arraySet = new HashSet<>(Math.min(nums1.length, nums2.length));
        for (int number1 : nums1) {
            if (arraySet.contains(number1)) {
                continue;
            }
            for (int number2 : nums2) {
                if (number1 == number2) {
                    arraySet.add(number1);
                    break;
                }
            }
        }
        return arraySet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 思路：1.利用set.add特性/hashmap(set).contains思路是判断是否存在key/value
     *       如果集合不存在该元素则添加成功，add方法返回true
     *       如果集合已存在该元素则添加失败，add方法返回false
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        // 字典集合
        Set<Integer> arraySet = new HashSet<>(nums1.length);
        // 交集集合
        List<Integer> arrayList = new ArrayList<>(Math.min(nums1.length, nums2.length));
        // 这里也可以写成  Set<Integer> arraySet = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        for (int num : nums1) {
            arraySet.add(num);
        }
        for (int num : nums2) {
            if (!arraySet.add(num)) {
                arrayList.add(num);
            }
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
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
    public int[] intersection3(int[] nums1, int[] nums2) {
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
                // 这里的index指向的数组中的尾部元素，不是尾部元素的下一个下标
                if (index == 0 || arr[index] != nums1[index1]) {
                    arr[++index] = nums1[index1];
                }
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
}
