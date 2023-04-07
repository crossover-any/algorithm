package order.leetcode;

/**
 * 给你一个整数 n，请你判断该整数是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得n == 3x ，则认为 n 是 3 的幂次方。
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *
 * @author tengxq
 */
public class LeetCode0231PowerOfFour {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
