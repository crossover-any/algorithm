package order._1137;

/**
 * 泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * @author tengxq
 */
public class NthTribonacciNumberSolutiion {
    public static void main(String[] args) {

    }

    /**
     * 思路：这道题和斐波那契数列{@link order._509.FibonacciNumberSolution}
     * 区别是第n个数等于前三个之和,斐波那契数列是两个。
     * <p>
     * 时间复杂度：O（n^3）
     * 空间复杂度：O（1）
     *
     * @param n 第n个泰波那契数列
     * @return 第n个泰波那契数列值
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    /**
     * 思路：上面方法1的时间复杂度过高，对比斐波那契数列分析得知是重复计算的原因
     * 需要使用打表的方式减少不必要的计算
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param n 第n个泰波那契数列
     * @return 第n个泰波那契数列值
     */
    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
