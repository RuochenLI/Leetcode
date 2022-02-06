package exercises.leetcode1_200;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int remaining = 0;
        while (i >= 0 || j >= 0) {
            int first = i >= 0 ? Integer.parseInt(Character.toString(a.charAt(i))) : 0;
            int sec = j >= 0 ? Integer.parseInt(Character.toString(b.charAt(j))) : 0;
            int current = first + sec + remaining;
            result.append(current % 2);
            remaining = current / 2;
            i--;
            j--;
        }
        if (remaining > 0) result.append(remaining);
        return result.reverse().toString();
    }
}
