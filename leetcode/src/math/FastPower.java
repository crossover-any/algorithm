package math;

/**
 * 快速幂
 *
 * @author tengxq
 */
public class FastPower {

    /**
     * 快速幂求x^n(递归)
     * @param x 底数
     * @param n 幂
     * @return 结果
     */
    public int power1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return x * power1(x, n >> 1);
        }
        return power1(x, n >> 1);
    }

    /**
     * 快速幂求x^n(非递归)
     * @param x 底数
     * @param n 幂
     * @return 结果
     */
    public int power2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
