package exercises.leetcode801_1000;

import java.util.Map;
import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 */
public class OddEvenJump_975 {
    /*单调队列不成立
    example {1,2,3,2,1,4,4,5}
    public int oddEvenJumps0(int[] arr) {
        boolean[] odd = new boolean[arr.length];
        boolean[] even = new boolean[arr.length];
        Stack<Integer> oddIncreaseStack = new Stack<>();
        Stack<Integer> evenDecreaseStack = new Stack<>();

        int count = 1;
        odd[arr.length - 1] = true;
        even[arr.length - 1] = true;
        oddIncreaseStack.push(arr.length - 1);
        evenDecreaseStack.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!oddIncreaseStack.isEmpty() && arr[oddIncreaseStack.peek()] < arr[i]) {
                oddIncreaseStack.pop();
            }
            odd[i] = !oddIncreaseStack.isEmpty() && even[oddIncreaseStack.peek()];
            oddIncreaseStack.push(i);
            while (!evenDecreaseStack.isEmpty() && arr[evenDecreaseStack.peek()] > arr[i]) {
                evenDecreaseStack.pop();
            }
            even[i] = !evenDecreaseStack.isEmpty() && odd[evenDecreaseStack.peek()];
            evenDecreaseStack.push(i);
            if (odd[i]) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }

     */

    public int oddEvenJumps(int[] arr) {
        int n = arr.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]), lo = map.floorEntry(arr[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }
            if (higher[i]) {
                res++;
                System.out.println(i);
            }
            map.put(arr[i], i);
        }
        return res;
    }
}
