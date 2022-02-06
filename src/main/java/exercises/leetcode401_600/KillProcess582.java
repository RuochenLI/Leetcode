package exercises.leetcode401_600;

import java.util.*;

public class KillProcess582 {
    Map<Integer, List<Integer>> parentMap;
    List<Integer> result;

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        parentMap = new HashMap<>();
        result = new ArrayList<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> sonList = parentMap.getOrDefault(ppid.get(i), new ArrayList<>());
            sonList.add(pid.get(i));
            parentMap.put(ppid.get(i), sonList);
        };
        killTheProcess(List.of(kill));
        return result;
    }

    private void killTheProcess(List<Integer> kills) {
        for (int kill : kills) {
            System.out.println(kill);
            if (parentMap.containsKey(kill)) {
                killTheProcess(parentMap.get(kill));
            }
            result.add(kill);
        }
    }
}
