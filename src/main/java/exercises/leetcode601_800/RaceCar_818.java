package exercises.leetcode601_800;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class RaceCar_818 {
    public int racecar(int target) {
        int nbRound = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{0, 1});
        visited.add(0 + " " + 1);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] current = queue.poll();
                int pos = current[0];
                int speed = current[1];
                if (pos == target) {
                    return nbRound;
                }
                int newPos = pos + speed;
                int newSpeed = speed << 1;
                String newStat = newPos + " " + newSpeed;
                if (!visited.contains(newStat) && newPos > 0 && newPos < (target << 1)) {
                    queue.offer(new int[]{newPos, newSpeed});
                    visited.add(newStat);
                }
                newPos = pos;
                newSpeed = speed > 0 ? -1 : 1;
                newStat = newPos + " " + newSpeed;
                if (!visited.contains(newStat) && newPos > 0 && newPos < (target << 1)) {
                    queue.offer(new int[]{newPos, newSpeed});
                    visited.add(newStat);
                }
            }
            nbRound++;
        }
        return nbRound;
    }

    public int racecar0(int target) {
        Deque<Status> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Status(0, 1, ""));
        visited.add(String.format("%d,%d", 0, 1));

        while (!queue.isEmpty()) {
            Status current = queue.poll();
            if (current.position == target) {
                return current.instructions.length();
            }

            int newPos = current.position + current.speed;
            int newSpeed = current.speed * 2;
            String newStat = String.format("%d,%d", newPos, newSpeed);
            if (!visited.contains(newStat)) {
                queue.offer(new Status(newPos, newSpeed, current.instructions + "A"));
                visited.add(newStat);
            }
            newPos = current.position;
            newSpeed = current.speed > 0 ? -1 : 1;
            newStat = String.format("%d,%d", newPos, newSpeed);
            if (!visited.contains(newStat)) {
                queue.offer(new Status(newPos, newSpeed, current.instructions + "R"));
                visited.add(newStat);
            }
        }
        return -1;
    }

    class Status {
        int position;
        int speed;
        String instructions;
        public Status(int position, int speed, String instructions) {
            this.position = position;
            this.speed = speed;
            this.instructions = instructions;
        }
    }
}
