package order.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *输入：matrix = [[1,4,7,11,15],
 *              [2,5,8,12,19],
 *              [3,6,9,16,22],
 *              [10,13,14,17,24],
 *              [18,21,23,26,30]], target = 5
 * 输出：true
 *
 * @author tengxq
 */
public class LeetCode0240SearchA2DMatrix {

    /**
     * 思路分析：双指针
     * 从右上角开始遍历，matrix[i][j] i=0, j=matrix[].length-1;
     * @param matrix 二维数组
     * @param target 目标值
     * @return 是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (0 <= j && i < matrix.length) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
