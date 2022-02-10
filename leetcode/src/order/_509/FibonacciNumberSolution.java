package order._509;

/**
 * 斐波那契数列
 *
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 *
 *
 * @author tengxq
 */
public class FibonacciNumberSolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：斐波那契数列是递归对经典例子，每个数都要由前面的数求和
     *      而前面的数也要由更往前的数的求和而得到。直到n=1或0。
     *      这比较像我们数学中的复合函数，f(f(1))这种
     *
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     * @param n 第n个数
     * @return 第n个数的前两数之和
     */
    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n -2);
    }

    /**
     * 思路：方法1存在重复计算的问题，例如 计算f(10)=f(9) + f(8);
     *      f(9) = f(8) + f(7), 这里f(8)需要计算两次。存在重复
     *      计算的问题，如果我们将f(8)第一次计算的值存储起来，下一次
     *      需要f(8)的时候我们先看这个值有没有计算过，如果计算过我们
     *      直接取出来即可，防止不必要的资源消耗。
     *
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     * @param n 第n个数
     * @return 第n个数的前两数之和
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        // 多申请1个空间，因为dp[n]应该为n+1下标才不会越界
        int[] dp = new int[n + 1];
        // 在java中int初始数据都为0，只需要设置dp[1]即可
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // f(n) = f(n-1) + f(n-2)
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
}
