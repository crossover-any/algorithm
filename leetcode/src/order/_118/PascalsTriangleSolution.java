package order._118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author tengxq
 */
public class PascalsTriangleSolution {
    public static void main(String[] args) {
        PascalsTriangleSolution pascalsTriangleSolution = new PascalsTriangleSolution();
        System.out.println(pascalsTriangleSolution.generate(2));
    }

    /**
     * 思路：根据杨辉三角特性
     * a.周边元素都是1
     * b.中间元素都值等于由上层紧密连接的元素和
     * <p>
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     *
     * @param numRows 杨辉三角的前numRows行
     * @return 杨辉三角集合
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        // 从右至左
        for (int i = 1; i <= numRows; i++) {
            calRowValueFromBottomToTop(rows, numRows, i);
        }
        return rows;
    }

    /**
     * 由下至上计算指定杨辉三角行列值
     *
     * @param rows   杨辉三角集合
     * @param row    杨辉三角行
     * @param column 杨辉三角列
     * @return 指定行列值
     */
    public int calRowValueFromBottomToTop(List<List<Integer>> rows, int row, int column) {
        if (column < 1 || column > row) {
            return 0;
        }
        List<Integer> list = null;
        if (row > rows.size()) {
            list = new ArrayList<>(row);
        } else {
            list = rows.get(row - 1);
        }
        if (list.size() > 0 && column <= list.size()) {
            return list.get(column - 1);
        }
        int parentRight = calRowValueFromBottomToTop(rows, row - 1, column - 1);
        int parentLeft = calRowValueFromBottomToTop(rows, row - 1, column);
        int value = parentRight + parentLeft;
        value = value == 0 ? 1: value;
        list.add(value);
        rows.add(list);
        return value;
    }
}
