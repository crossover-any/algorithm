package order.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author tengxq
 */
public class LeetCode0070ClimbingStairsSolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：
     *      假设只有1阶梯，那么只有一种方式
     *      假设有2阶梯，那么可以选择（1，1）与（2）两种方式
     *      假设有3阶梯，我们可以从第二阶梯跨1步来到3阶梯，或者从1阶梯跨2步来到3阶梯
     *      那到3阶梯的方式就有 到1阶梯到方式再加上到2阶梯到方式
     * <p>
     *      ...
     *      假设有n阶梯，我们从n-1阶梯跨1步，或者从n-2阶梯跨2步 f(n) = f(n - 1) + f(n -2)
     * <p>
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（n）
     *
     * @param n 阶梯数量
     * @return 不同方法
     */
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 思路：方法1的缺点是存在重复计算的问题，这是递归中常见的问题
     *      一般递归都会转化成动态规划来减少时间复杂度。
     *      示例：求到达5阶梯有多少种不同的方式
     *      根据方法1来模拟过程。
     *      f(5) = f(4) + f(3)
     *      计算f(4)
     *      f(4) = f(3) + f(2)
     *      f(3) = f(2) + f(1)
     *      f(2) = 2
     *      f(1) = 1
     *      计算f(3)
     *      f(3) = f(2) + f(1)
     *      f(2) = 2
     *      f(1) = 1
     *      通过模拟计算我们可以观察到在计算到达4阶梯到不同方式中就已经包含来计算到
     *      3阶梯到不同方式，但是f(5) = f(4) + f(3),又要单独计算f(3)的不同方式
     *      那我们就可以打表来较少时间复杂度
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param n 阶梯数量
     * @return 不同方法
     */
    public int climbStairs2(int n) {
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 思路：通过观察方法2的dp[i] = dp[i-1] + dp[i -2]
     *      得知每次我们计算只需要前面两个数，因此我们可以
     *      使用两个变量来替换申请的n个空间，降低空间复杂度
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param n 阶梯数量
     * @return 不同方法
     */
    public int climbStairs3(int n) {
        if (n < 4) {
            return n;
        }
        // 从第三阶梯开始遍历，阶梯1距离阶梯3有两步，阶梯2距离阶梯3有一步
        // 到达阶梯1有1种方式，到达阶梯2有2种方式
        int stepTwo = 1;
        int stepOne = 2;
        int stepI = 0;
        for (int i = 3; i < n; i++) {
            // 到达阶梯I的方式由到前一步阶梯与前两步阶梯之和
            stepI = stepOne + stepTwo;
            // 因为向后移动，距离当前阶梯1步的阶梯会变成距离2步了
            stepTwo = stepOne;
            // 当前阶梯变成距离下一阶梯剩1阶梯
            stepOne = stepI;
        }
        return stepOne + stepTwo;
    }
}
