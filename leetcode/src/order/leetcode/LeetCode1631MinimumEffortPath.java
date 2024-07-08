package order.leetcode;

/**
 * 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 * @author tengxq
 */
public class LeetCode1631MinimumEffortPath {

    int[][] heights = null;
    boolean[][] mark = null;
    int min = Integer.MAX_VALUE;

    int row;
    int col;

    public int minimumEffortPath(int[][] heights) {
        this.mark = new boolean[heights.length][heights[0].length];
        this.heights = heights;
        row = heights.length -1;
        col = heights[0].length -1;
        find(0,0, heights[0][0],0);
        return min;
    }

    public void find(int i, int j, int preNum, int maxAbs) {
        if (j < 0 || j > col || i <0 || i > row || mark[i][j]) {
            return;
        }
        int curNum = heights[i][j];
        int abs = Math.abs(curNum - preNum);
        maxAbs = Math.max(abs, maxAbs);
        if (i == row && j == col) {
            min = Math.min(min, maxAbs);
            return;
        }
        mark[i][j] = true;
        find(i-1, j, curNum, maxAbs);
        find(i + 1, j, curNum, maxAbs);
        find(i, j-1, curNum, maxAbs);
        find(i, j+1, curNum, maxAbs);
        mark[i][j] = false;
    }

    public static void main(String[] args) {
        LeetCode1631MinimumEffortPath solution = new LeetCode1631MinimumEffortPath();
        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        int i = solution.minimumEffortPath(heights);
        System.out.println(i);
    }

}
