package order._119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * @author tengxq
 */
public class YangHuiTriangle2Solution {

    public static void main(String[] args) {
        YangHuiTriangle2Solution solution = new YangHuiTriangle2Solution();
        System.out.println(solution.getRow2(1));
    }

    public List<Integer> getRow(int rowIndex) {

        return null;
    }

    /**
     * 思路：将杨辉三角用一个二维数组存起来，根据rowIndex去取
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)
     * @param rowIndex 行坐标
     * @return 行数据
     */
    public List<Integer> getRow1(int rowIndex) {
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        // init
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        return Arrays.stream(arr[rowIndex]).boxed().collect(Collectors.toList());
    }

    /**
     * 思路：将杨辉三角用一个二维数组存起来，根据rowIndex去取
     *      观察到这个数组是对称的，那我们可以只用存一半的信息
     *      就节约了一半的存储空间和计算时间
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)
     * @param rowIndex 行坐标
     * @return 行数据
     */
    public List<Integer> getRow2(int rowIndex) {
        int len = (rowIndex+2)/2;
        int[][] arr = new int[rowIndex][len];
        // init
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i && j < len; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        return Arrays.stream(arr[rowIndex - 1]).boxed().collect(Collectors.toList());
    }

}
