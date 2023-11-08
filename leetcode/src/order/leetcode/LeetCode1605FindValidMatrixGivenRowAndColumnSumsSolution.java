package order.leetcode;

/**
 * 给定行和列的和求可行矩阵
 *
 *
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 *       [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 *                 [3,5]]
 */
public class LeetCode1605FindValidMatrixGivenRowAndColumnSumsSolution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;            // 获取总行数
        int col = colSum.length;            // 获取总列数
        int[][] matrix = new int[row][col]; // 构造矩阵，初始化所有元素都为0
        int r = 0;  // 当前行 初始首行
        int c = 0;  // 当前列 初始首列
        while(r < row && c < col){  // 仅当行列都在范围内进行操作
            matrix[r][c] = Math.min(rowSum[r], colSum[c]);  // 构成matrix[r][c]
            rowSum[r] -= matrix[r][c];  // 所在行元素总和减少matrix[r][c]
            colSum[c] -= matrix[r][c];  // 所在列元素总和减少matrix[r][c]
            if(rowSum[r] == 0){
                // 所在行元素总和已为0，该行剩下元素都为0，处理下一行
                r++;
            }else{
                // 所在列元素总和已为0，该列剩下元素都为0，处理下一列
                c++;
            }
        }
        return matrix;
    }
}
