package interviews.google;

import java.util.*;

public class CourseSchedule {
    private int[] inDegree;
    private Map<Integer, List<Integer>> graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        graph = new HashMap<>();
        int courseDone = 0;
        for (int[] prerequiste : prerequisites) {
            inDegree[prerequiste[0]]++;
            if (!graph.containsKey(prerequiste[1])) {
                graph.put(prerequiste[1], new ArrayList<>());
            }
            graph.get(prerequiste[1]).add(prerequiste[0]);
        }

        for (int i = 0; i< numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseDone++;
            if (graph.containsKey(course)) {
                for (int nextCourse : graph.get(course)) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

        }

        return courseDone == numCourses;
    }
}
