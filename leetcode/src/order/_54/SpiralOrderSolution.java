package order._54;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author tengxq
 */
public class SpiralOrderSolution {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 2, 6}};
        SpiralOrderSolution spiralOrderSolution = new SpiralOrderSolution();
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> arr = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, down = matrix.length - 1;

        while (true) {
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            top++;
            if (top > down) break;
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            down--;
            if (top > down) break;
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }
}
