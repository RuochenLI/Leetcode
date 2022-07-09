package exercises.leetcode201_400;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues_225 {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
        }

        public Integer pop() {
            if (queue.isEmpty())
                return null;

            return queue.poll();
        }

        public Integer top() {
            if (queue.isEmpty())
                return null;

            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
