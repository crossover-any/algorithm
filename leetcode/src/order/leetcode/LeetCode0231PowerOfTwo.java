package order.leetcode;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 *
 *
 * @author tengxq
 */
public class LeetCode0231PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0 || n%2 == 1) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (-n)) == n;
    }
}
