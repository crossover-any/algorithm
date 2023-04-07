package order.leetcode;

/**
 * 一个整数 num的k美丽值定义为num中符合以下条件的子字符串数目：
 * <p>
 * 子字符串长度为k。
 * 子字符串能整除 num 。
 * 给你整数num 和k，请你返回num的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * 允许有前缀0。
 * 0不能整除任何值。
 * 一个 子字符串是一个字符串里的连续一段字符序列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * 示例 2：
 * <p>
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 *
 * @author tengxq
 */
public class LeetCode2269FindTheKBeautyOfANumber {

    public int divisorSubstrings(int num, int k) {
        int count = 0;
        int n = num;
        int x = 1;
        for (int i = 0; i < k; i++) {
            x = x * 10;
        }
        int y = x/10;
        while (n >= y) {
            int a = n % x;
            if (a != 0 && num % a == 0) {
                count++;
            }
            n /=10;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode2269FindTheKBeautyOfANumber solution = new LeetCode2269FindTheKBeautyOfANumber();
        System.out.println(solution.divisorSubstrings(10, 1));
    }
}
