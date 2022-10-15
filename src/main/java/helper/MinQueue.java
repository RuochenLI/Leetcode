package helper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a Queue data structure to get minimum or maximum in O(1) time
 */
public class MinQueue {
    Queue<Integer> q;
    Deque<Integer> dq;

    public MinQueue() {
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }

   public  void enque(int data) {
        // remove all elements from
        // from deque which are greater
        // than the current element 'data'
        while (!dq.isEmpty() && dq.getLast() > data) {
            dq.removeLast();
        }
        // If queue is empty then
        // while loop is skipped.
        dq.addLast(data);
        q.add(data);
    }

    public boolean deque() {
        // If min element is present
        // at front of queue
        if (dq.getFirst() == q.peek()) {
            dq.removeFirst();
        }
        q.remove();
        return false;
    }

    // Method to get min element in Queue
    public int getMin() throws RuntimeException {
        // If queue is Empty, return Exception
        if (q.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        } else {
            return dq.getFirst();
        }
    }
}