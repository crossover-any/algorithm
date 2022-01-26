package order._88;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 * @author tengxq
 */
public class MergeSortedArraySolution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArraySolution mergeSortedArraySolution = new MergeSortedArraySolution();
        mergeSortedArraySolution.merge1(nums1, 3, nums2, 3);
    }

    /**
     * 思想：将数组2拼接到数组1后面，然后用Arrays工具类的快排排序方法
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(logN)
     *
     * @param nums1 数组1
     * @param m 数组1需要拼接的个数
     * @param nums2 数组2
     * @param n 数组2需要凭借的个数
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 思想：利用两个指针（记录下标）依次对数组1数组2从小到大比较放入到一个新的排序的数组nums中
     *       将排序好的nums赋值给nums1
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums1 数组1
     * @param m 数组1需要拼接的个数
     * @param nums2 数组2
     * @param n 数组2需要凭借的个数
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int indexNum1 = 0;
        int indexNum2 = 0;
        int size = 0;
        int[] nums = new int[m + n];
        while (indexNum1 < m && indexNum2 < n) {
            if (nums1[indexNum1] <= nums2[indexNum2]) {
                nums[size++] = nums1[indexNum1++];
            } else {
                nums[size++] = nums2[indexNum2++];
            }
        }
        while (indexNum1 < m) {
            nums[size++] = nums1[indexNum1++];
        }
        while (indexNum2 < n) {
            nums[size++] = nums2[indexNum2++];
        }
        if (size >= 0) System.arraycopy(nums, 0, nums1, 0, size);
    }

    /**
     * 思想：这里同样借助两个指针对数组分别进行排序，但是显而易见，在题解二中我们开辟了一个新的
     *       空间去存储，这是从小到大的一个缺点，如果我们从尾部进行从大到小的排序那么我们将节约
     *       m+n个空间
     *
     * 问题：直接在num1中操作不会覆盖num1中的元素吗？
     * 解答：因为是有序数组，在任何时刻num1剩下的可操作性排序容量必定是num1待排序数量与num2待排序数量之和
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums1 数组1
     * @param m 数组1需要拼接的个数
     * @param nums2 数组2
     * @param n 数组2需要拼接的个数
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int indexNum1 = m - 1;
        int indexNum2 = n - 1;
        int size = m + n - 1;
        while (indexNum1 > 0 && indexNum2 > 0) {
            if (nums1[indexNum1] > nums2[indexNum2]) {
                nums1[size--] = nums1[indexNum1--];
            } else {
                nums1[size--] = nums2[indexNum2--];
            }
        }
        while (indexNum1 > 0) {
            nums1[size--] = nums1[indexNum1--];
        }
        while (indexNum2 > 0) {
            nums1[size--] = nums2[indexNum2--];
        }
    }
}
