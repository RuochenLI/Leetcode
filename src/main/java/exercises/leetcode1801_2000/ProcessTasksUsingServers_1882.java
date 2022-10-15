package exercises.leetcode1801_2000;

import java.util.PriorityQueue;

/**
 * 1882. Process Tasks Using Servers
 */
public class ProcessTasksUsingServers_1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Integer> availableServers = new PriorityQueue<>(servers.length,
                                                                      (a, b) -> servers[a] == servers[b]
                                                                                ? a - b
                                                                                : servers[a] - servers[b]);
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(servers.length,
                                                               (a, b) -> a[0] != b[0]
                                                                         ? a[0] - b[0]
                                                                         : (servers[b[1]] != servers[a[1]]
                                                                            ? servers[a[1]] - servers[b[1]]
                                                                            : a[1] - b[1]));

        for (int i = 0; i < servers.length; i++) {
            availableServers.offer(i);
        }

        int[] result = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                int[] finishedServer = busyServers.poll();
                availableServers.offer(finishedServer[1]);
            }

            if (availableServers.isEmpty()) {
                int[] busyServer = busyServers.poll();
                result[i] = busyServer[1];
                busyServers.offer(new int[]{busyServer[0] + tasks[i], busyServer[1]});
            } else {
                int server = availableServers.poll();
                result[i] = server;
                busyServers.offer(new int[]{i + tasks[i], server});
            }
        }
        return result;
    }
}
