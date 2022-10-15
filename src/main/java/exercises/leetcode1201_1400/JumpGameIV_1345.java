package exercises.leetcode1201_1400;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1345. Jump Game IV
 */
public class JumpGameIV_1345 {
    // BFS
    public int minJumps0(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numIndexMap.computeIfAbsent(arr[i], a -> new LinkedList<>()).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                if (pos == n - 1) {
                    return step;
                }
                visited.add(pos);
                for (int newPos : numIndexMap.get(arr[pos])) {
                    if (!visited.contains(newPos)) {
                        queue.offer(newPos);
                    }
                }
                // clear the list to prevent redundant search
                numIndexMap.get(arr[pos]).clear();

                if (pos - 1 >= 0 && !visited.contains(pos - 1)) {
                    queue.offer(pos - 1);
                }
                if (pos + 1 < n && !visited.contains(pos + 1)) {
                    queue.offer(pos + 1);
                }
            }
            step++;
        }
        return -1;
    }

    // Bi-direction BFS
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        HashSet<Integer> curs = new HashSet<>(); // store layers from start
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(n - 1);
        int step = 0;

        HashSet<Integer> other = new HashSet<>(); // store layers from end
        other.add(n - 1);

        // when current layer exists
        while (!curs.isEmpty()) {
            // search from the side with fewer nodes
            if (curs.size() > other.size()) {
                HashSet<Integer> tmp = curs;
                curs = other;
                other = tmp;
            }

            HashSet<Integer> nex = new HashSet<>();

            // iterate the layer
            for (int node : curs) {

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (other.contains(child)) {
                        return step + 1;
                    }
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (other.contains(node + 1) || other.contains(node - 1)) {
                    return step + 1;
                }

                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nex.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nex.add(node - 1);
                }
            }

            curs = nex;
            step++;
        }

        return -1;
    }
}
