package order.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 你总共需要上numCourses门课，课程编号依次为 0到numCourses-1。你会得到一个数组prerequisite ，其中prerequisites[i] = [ai, bi]表示如果你想选bi 课程，你 必须 先选ai课程。
 *
 * 有的课会有直接的先修课程，比如如果想上课程 1，你必须先上课程 0，那么会以 [0,1]数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 *
 * 你也得到一个数组queries，其中queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程uj是否是课程vj的先决条件。
 *
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 *
 *
 * @author tengxq
 */
public class LeetCode1462CourseSchedule4 {
    List<List<Integer>> edges;
    int[] visited;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        edges = new ArrayList<>(numCourses);
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int[] query : queries) {
            result.add(dfs(query[0], query[1]));
        }
        return result;
    }

    public boolean dfs(int index, int target) {
        visited[index] = 1;
        for (Integer i : edges.get(index)) {
            if (i == target) {
                return true;
            }
            if (visited[i] == 0) {
                return dfs(i, target);
            } else if (visited[i] == 1) {
                return false;
            }
        }
        visited[index] = 2;
        return false;
    }
}
