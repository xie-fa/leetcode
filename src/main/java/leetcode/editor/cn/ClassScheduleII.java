package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11757
 * @date 2022/3/11
 **/
public class ClassScheduleII {

    //有向图
    List<List<Integer>> edges;
    //标记每个节点的状态：0=未搜索；1=搜索中；2=已完成
    int[] visited;
    //模拟
    int[] stack;
    //检验是否有环
    boolean valid = true;
    //栈坐标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];
        stack = new int[numCourses];
        index = numCourses - 1;
        for (int[] ints : prerequisites) {
            edges.get(ints[1]).add(ints[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return stack;
    }

    private void dfs(int x) {
        visited[x] = 1;

        for (int v : edges.get(x)) {
            if (visited[v] == 0) {
                dfs(v);
            }
            if (!valid) {
                return;
            } else if (visited[v] == 1) {
                //环
                valid = false;
                return;
            }
        }

        visited[x] = 2;
        stack[index--] = x;
    }
}
