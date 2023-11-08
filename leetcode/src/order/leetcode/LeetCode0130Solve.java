package order.leetcode;


import java.util.Arrays;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCode0130Solve {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'X'}
        };
        LeetCode0130Solve solve = new LeetCode0130Solve();
        solve.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }


    public void solve(char[][] board) {
        // flag 初始为0， 寻找中 1， 有出口 2， 没有出口 3
        STATUS[][] flag = new STATUS[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !markWay(board, flag, i, j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean markWay(char[][] board, STATUS[][] flag, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == STATUS.SUCCESS) {
            return true;
        }
        if (flag[i][j] == STATUS.FINDING) {
            // 如果当前位置处于搜索中，则不能找到出口
            return false;
        }
        if (board[i][j] == 'O') {
            flag[i][j] = STATUS.FINDING;
            // 继续寻找上下左右出口
            boolean result = markWay(board, flag, i - 1, j) ||
                    markWay(board, flag, i + 1, j) ||
                    markWay(board, flag, i, j - 1) ||
                    markWay(board, flag, i, j + 1);
            if (result) {
                flag[i][j] = STATUS.SUCCESS;
            } else {
                flag[i][j] = STATUS.FAIL;
            }
            return result;
        }
        // X 标记为找不到出口
        flag[i][j] = STATUS.FAIL;
        return false;
    }

    enum STATUS {
        INIT, FINDING, SUCCESS, FAIL
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }

        }

        int find(int node) {
            // 有领导
            while (parents[node] != node) {
                // 取领导的领导
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root1] = parents[root2];
            }
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
