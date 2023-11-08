package order.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCode0200NumIslands {

    public static void main(String[] args) {
        LeetCode0200NumIslands solution = new LeetCode0200NumIslands();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    markedByBFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void markedByDFS(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            markedByDFS(grid, i - 1, j);
            markedByDFS(grid, i + 1, j);
            markedByDFS(grid, i, j + 1);
            markedByDFS(grid, i, j - 1);
        }


    }

    public void markedByBFS(char[][] grid, int i, int j) {
        int index = grid[0].length * i + j;
        int row, col;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            index = queue.poll();
            row = index / grid[0].length;
            col = index % grid[0].length;
            if (grid[row][col] == '1') {
                grid[row][col] = '2';
                // 把周围'1'入队
                offerQueue(grid, row - 1, col, queue);
                offerQueue(grid, row + 1, col, queue);
                offerQueue(grid, row, col - 1, queue);
                offerQueue(grid, row, col + 1, queue);
            }
        }
    }

    private void offerQueue(char[][] grid, int i, int j, Queue<Integer> queue) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            queue.offer(grid[0].length * i + j);
        }
    }
}
