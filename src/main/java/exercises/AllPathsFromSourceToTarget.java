package exercises;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    private List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        result = new ArrayList<>();
        visit(graph, visited, 0, new ArrayList());
        return result;
    }

    private void visit(int[][] graph, boolean[] visited, int currentNode, List<Integer> path) {
        path.add(currentNode);
        visited[currentNode] = true;
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            for (int num : graph[currentNode]) {
                if (!visited[num]) {
                    visit(graph, visited, num, path);
                }
            }
        }
        path.remove((Integer) currentNode);
        visited[currentNode] = false;
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget test = new AllPathsFromSourceToTarget();
        test.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
    }
}
