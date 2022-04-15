package exercises.leetcode201_400;

import java.util.*;

public class RemoveInvalidParentheses {
    ArrayList<String> result;
    Set<String> visited;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        visited = new HashSet<>();
        LinkedList<Status> statuses = init(s);
        bfs(statuses);
        return result;
    }

    private void bfs(LinkedList<Status> statuses) {
        while (!statuses.isEmpty()) {
            Status currentStatus = statuses.poll();
            if (currentStatus.left == 0 && currentStatus.right == 0) {
                if (!result.contains(currentStatus.s) && valid(currentStatus.s)) {
                    result.add(currentStatus.s);
                }
            } else {
                for (int i = 0; i < currentStatus.s.length(); i++) {
                    char c = currentStatus.s.charAt(i);
                    String newString = currentStatus.s.substring(0, i) + currentStatus.s.substring(i + 1);
                    if (!visited.contains(newString)) {
                        if (c == '(' && currentStatus.left > 0) {
                            Status newStatus = new Status(newString, currentStatus.left - 1, currentStatus.right);
                            statuses.offer(newStatus);
                            visited.add(newString);
                        }

                        if (c == ')' && currentStatus.right > 0) {
                            Status newStatus = new Status(newString, currentStatus.left, currentStatus.right - 1);
                            statuses.offer(newStatus);
                            visited.add(newString);
                        }
                    }

                }
            }
        }
    }

    private LinkedList<Status> init(String s) {
        int count = 0;
        int left;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count > 0) {
                    count--;
                } else {
                    right++;
                }
            }
        }
        left = count;
        LinkedList<Status> statuses = new LinkedList<>();
        Status status = new Status(s, left, right);
        statuses.offer(status);
        visited.add(s);
        return statuses;
    }

    private boolean valid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static class Status {
        String s;
        int left;
        int right;

        public Status(String s, int left, int right) {
            this.s = s;
            this.left = left;
            this.right = right;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            Status status = (Status) o;

            return s.equals(status.s) && left == status.left && right == status.right;
        }
    }
}
