package order.leetcode;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * <p>
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * @author tengxq
 */
public class LeetCode0011ContainerWithMostWater {


    /**
     * 思路：双指针，决定容器的容量的是最小高度，
     * 假设 1. i < j.
     * 2. height[i] < height[j]
     * 此时容器的容量(这里看做面积)等于 (j-i)*height[i]，
     * a.假设存在x, i < x < j,
     * b.当 height[x] < height[i]时，容量更小，因为x-i < j-i,并且 height[x] < height[i]
     * c.当 height[x] >= height[i]时，容量也会更小,因为 x -i < j-i, 虽然height[x] > height[i],这里决定容量的还是height[i]
     * 通过以上的分析，我们可以用双指针的方式，p在起始位置，q在末尾，想要寻找最大容量，指针要忘越高的地方移动
     *
     * @param height 高度数组
     * @return 最大容量
     */
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int p = 0;
        int q = height.length - 1;
        int capacity = 0;
        while (p < q) {
            capacity = (q - p) * Math.min(height[p], height[q]);
            max = Math.max(max, capacity);
            if (height[p] < height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return max;
    }

}
