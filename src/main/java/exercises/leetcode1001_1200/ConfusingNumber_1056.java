package exercises.leetcode1001_1200;

public class ConfusingNumber_1056 {
    public boolean confusingNumber(int N) {
        String s = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') {
                return false;
            }
            if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                sb.append(c);
            }
        }
        return !sb.reverse().toString().equals(s);
    }
}
