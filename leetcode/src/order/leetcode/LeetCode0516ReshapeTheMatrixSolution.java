package order.leetcode;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，
 * 它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的m x n 矩阵，
 * 以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * @author tengxq
 */
public class LeetCode0516ReshapeTheMatrixSolution {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2}, {3, 4}};
        LeetCode0516ReshapeTheMatrixSolution reshapeTheMatrixSolution = new LeetCode0516ReshapeTheMatrixSolution();
        reshapeTheMatrixSolution.matrixReshape(mat, 1, 4);
    }

    /**
     * 思路：题目要求根据行优先遍历顺序构造新的矩阵，这里主要是对元素的一个映射关系
     * 主要是计算当前mat[i][j]元素的编号
     * 为了方便起见我们从0开始编号 0 1 2 3 4 ... n
     * 如果新的矩阵列是c,那么我们遍历到0 1...c-1刚好可以组成一行数组
     * 添加到第c个元素后需要放进下一行，可以找到规律
     * 新矩阵的列号=元素编号对列求余
     * 新矩阵对行号=元素编号除以列
     * 元素编号我们可用一个计数器来计算，也可根据 i,j的值来计算，index = (i * m) + j
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param mat 矩阵
     * @param r   转化矩阵第行数
     * @param c   转化矩阵第列数
     * @return 转化后的矩阵
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] arr = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++, index++) {
                arr[index / c][index % c] = mat[i][j];
            }
        }
        return arr;
    }
}
