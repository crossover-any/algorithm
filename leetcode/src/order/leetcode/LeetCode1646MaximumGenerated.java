package order.leetcode;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCode1646MaximumGenerated {

    public int getMaximumGenerated(int n) {
        int max = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i%2==0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i/2] + dp[i/2+1];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
