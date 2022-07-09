package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary_332 {
    List<String> result;

    public List<String> findItinerary1(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        dfs(tickets, used, new ArrayList<>());
        return result;
    }

    void dfs(List<List<String>> tickets, boolean[] used, List<String> itinerary) {
        if (itinerary.size() == tickets.size() + 1) {
            for (final String s : itinerary) {
                System.out.print(s + "->");
            }
            System.out.println();
            if (result == null || compareItinerary(itinerary, result)) {
                result = List.copyOf(itinerary);
            }
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (itinerary.isEmpty()) {
                if (!tickets.get(i).get(0).equals("JFK")) {
                    continue;
                } else {
                    used[i] = true;
                    itinerary.add(tickets.get(i).get(0));
                    itinerary.add(tickets.get(i).get(1));
                    dfs(tickets, used, itinerary);
                    itinerary.remove(tickets.get(i).get(0));
                    itinerary.remove(tickets.get(i).get(1));
                    used[i] = false;
                }
            } else if (!used[i] && itinerary.get(itinerary.size() - 1).equals(tickets.get(i).get(0))) {
                used[i] = true;
                itinerary.add(tickets.get(i).get(1));
                dfs(tickets, used, itinerary);
                itinerary.remove(tickets.get(i).get(1));
                used[i] = false;
            }
        }
    }

    private boolean compareItinerary(final List<String> itinerary0, final List<String> itinerary1) {
        for (int i = 0; i < itinerary0.size(); i++) {
            int compare = itinerary0.get(i).compareTo(itinerary1.get(i));
            if (compare < 0) {
                return true;
            } else if (compare > 0) {
                return false;
            }
        }

        return false;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return route;
    }

    void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll());
        }
        route.add(0, airport);
    }
}
