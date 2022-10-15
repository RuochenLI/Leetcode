package exercises.leetcode201_400;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}

