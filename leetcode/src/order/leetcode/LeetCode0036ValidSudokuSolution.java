package order.leetcode;

import java.util.*;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *
 * @author tengxq
 */
public class LeetCode0036ValidSudokuSolution {
    public static void main(String[] args) {

    }

    /**
     * 思路：根据数独特点
     *  a. 行不能重复
     *  b. 列不能重复
     *  c. 3x3区域不能重复（boxId = i/3 * 3 + j/3）
     * 分别建立三个字典来记录已经扫描到到值
     *
     *  时间复杂度 O（1）
     *  空间复杂度 O（1）
     *
     * @param board 数组
     * @return 是否是数独
     */
    public boolean isValidSudoku(char[][] board) {
        // 记录行数字
        Map<Integer, Set<Integer>> row = new HashMap<>(9);
        // 记录列数字
        Map<Integer, Set<Integer>> col = new HashMap<>(9);
        // 记录块数字
        Map<Integer, Set<Integer>> box = new HashMap<>(9);
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>(9));
            col.put(i, new HashSet<>(9));
            box.put(i, new HashSet<>(9));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int u = c - '0';
                int boxId = i / 3 * 3 + j / 3;
                if (row.get(i).contains(u) || col.get(j).contains(u) || box.get(boxId).contains(u)) {
                    return false;
                }
                row.get(i).add(u);
                col.get(j).add(u);
                box.get(boxId).add(u);
            }
        }
        return true;
    }
}
