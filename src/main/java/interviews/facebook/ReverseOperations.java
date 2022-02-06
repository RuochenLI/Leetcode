package interviews.facebook;

import java.util.LinkedList;

public class ReverseOperations {
    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    Node reverseOdds(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.data % 2 == 0) {
            Node t = curr.next;
            curr.next = prev;

            prev = curr;
            curr = t;
        }

        head.next = curr;
        return prev;
    }

    Node reverse(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                prev.next = reverseOdds(curr);
            }

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

//    Node reverse(Node head) {
//
//        Node result = head;
//        Node prev = head.data % 2 == 0 ? null : head;
//        Node pointer = head;
//        LinkedList<Node> steak = new LinkedList<>();
//        while (pointer != null) {
//            if (pointer.data % 2 == 0){
//                Node evenPointer = pointer;
//                while (evenPointer != null && evenPointer.data % 2 == 0) {
//                    steak.push(evenPointer);
//                    evenPointer = evenPointer.next;
//                }
//                while (!steak.isEmpty()) {
//                    if (prev == null) {
//                        result = steak.pop();
//                        prev = result;
//                    } else {
//                        prev.next = steak.pop();
//                        prev = prev.next;
//                    }
//                }
//                prev.next = evenPointer;
//                prev = evenPointer;
//                pointer = evenPointer;
//            } else {
//                prev = pointer;
//                pointer = pointer.next;
//            }
//        }
//        return result;
//    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }
    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = {1, 2, 8, 6, 9, 12, 16};
        int[] expected1 = {1, 6, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseOperations().run();
    }
}
