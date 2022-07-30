package exercises.leetcode1601_1800;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 1606. Find Servers That Handled Most Number of Requests
 */
public class FindServersThatHandledMostNumberofRequests_1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counter = new int[k];
        // use a tree to track available servers
        TreeSet<Integer> available = new TreeSet<>();
        for (int num = 0; num < k; num++) {
            available.add(num);
        }
        // use a PQ to maintain the availability at current arrival time
        Queue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int idx = 0; idx < arrival.length; idx++) {
            int curTime = arrival[idx];
            int endTime = curTime + load[idx];
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= curTime) {
                int freedServer = busyServers.poll()[1];
                available.add(freedServer);
            }
            if (available.size() == 0) continue; // all busy
            Integer assignNum = available.ceiling(idx % k);
            if (assignNum == null) {
                assignNum = available.first();
            }
            counter[assignNum]++;
            available.remove(assignNum);
            busyServers.offer(new int[] {endTime, assignNum});
        }

        return findMaxesInCounter(counter);
    }

    private List<Integer> findMaxesInCounter(int[] counter) {
        int max = 0;
        for (final int j : counter) {
            max = Math.max(max, j);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == max) {
                result.add(i);
            }
        }
        return result;
    }


    List<Stack<int[]>> servers;

    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        servers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            servers.add(new Stack<>());
        }
        int max = 0;
        for (int i = 0; i < arrival.length; i++) {
            Integer serverId = findAvailableServer(k, arrival[i], i);
            if (serverId != null) {
                Stack<int[]> server = servers.get(serverId);
                server.push(new int[]{arrival[i], load[i]});
                max = Math.max(max, server.size());
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).size() == max) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> busiestServers0(int k, int[] arrival, int[] load) {
        servers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            servers.add(new Stack<>());
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrival.length; i++) {
            Integer serverId = findAvailableServer(k, arrival[i], i);
            if (serverId != null) {
                Stack<int[]> server = servers.get(serverId);
                server.push(new int[]{arrival[i], load[i]});
                if (server.size() > max) {
                    max = server.size();
                    result = new ArrayList<>();
                    result.add(serverId);
                } else if (server.size() == max) {
                    result.add(serverId);
                }
            }
        }
        return result;
    }

    private Integer findAvailableServer(final int k, final int startTime, final int indexTask) {
        int indexServer = indexTask % k;
        if (isAvailable(startTime, indexServer)) {
            return indexServer;
        }

        int pt = indexServer + 1;
        if (pt >= k) {
            pt = 0;
        }
        while (pt != indexServer) {
            if (isAvailable(startTime, pt)) {
                return pt;
            }
            pt++;
            if (pt >= k) {
                pt = 0;
            }
        }
        return null;
    }

    private boolean isAvailable(final int startTime, final int indexServer) {
        return servers.get(indexServer).isEmpty() ||
               servers.get(indexServer).peek()[0] + servers.get(indexServer).peek()[1] <= startTime;
    }
}
