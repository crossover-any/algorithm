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
        System.out.println(pascalsTriangleSolution.generate2(5));
    }

    /**
     * 思路：根据杨辉三角特性
     * a.周边元素都是1
     * b.中间元素都值等于由上层紧密连接的元素和
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param numRows 杨辉三角的前numRows行
     * @return 杨辉三角集合
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        // 从左至右
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                int val =0;
                // 每行的第一个元素和最后一个元素都是 1
                if (j == 1 || j == i) {
                    val = 1;
                } else {
                    // 获取上一行数据
                    List<Integer> preRow = rows.get(i - 2);
                    val = preRow.get(j - 2) + preRow.get(j -1);
                }
                row.add(val);
            }
            rows.add(row);
        }
        return rows;
    }

    /**
     * 思路：根据杨辉三角特性
     * a.周边元素都是1
     * b.中间元素都值等于由上层紧密连接的元素和
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param numRows 杨辉三角的前numRows行
     * @return 杨辉三角集合
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        // 从左至右
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                int val =0;
                // 每行的第一个元素和最后一个元素都是 1
                if (j == 0 || j == i) {
                    val = 1;
                } else {
                    // 获取上一行数据
                    List<Integer> preRow = rows.get(i - 1);
                    val = preRow.get(j - 1) + preRow.get(j);
                }
                row.add(val);
            }
            rows.add(row);
        }
        return rows;
    }

    /**
     * 思路：根据杨辉三角特性
     * a.周边元素都是1
     * b.中间元素都值等于由上层紧密连接的元素和
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param numRows 杨辉三角的前numRows行
     * @return 杨辉三角集合
     */
    public List<List<Integer>> generate3(int numRows) {
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
        // 如果超出边界返回 0，因为我们的任意值都是由两个数之和而来的
        if (column < 1 || column > row) {
            return 0;
        }
        List<Integer> list = null;
        // 如果当前行号大于集合大小，证明需要初始化
        if (row > rows.size()) {
            list = new ArrayList<>(row);
        } else {
            list = rows.get(row - 1);
        }
        // 如果要取的值已经存在（比如我要取3行的2列，如果list.size = 3，证明已经存在），直接返回
        if (column <= list.size()) {
            return list.get(column - 1);
        }
        int parentRight = calRowValueFromBottomToTop(rows, row - 1, column - 1);
        int parentLeft = calRowValueFromBottomToTop(rows, row - 1, column);
        int value = parentRight + parentLeft;
        // 第一行数据的值左右相加等于0，这里手动赋值一下
        value = value == 0 ? 1: value;
        list.add(value);
        // 初始化并添加第一个数据后加入行集合
        if (list.size() == 1) {
            rows.add(list);
        }
        return value;
    }
}
