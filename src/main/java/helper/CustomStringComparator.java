package helper;

import java.util.Arrays;
import java.util.Comparator;

import com.google.common.base.Strings;

public class CustomStringComparator implements Comparator<String> {
    @Override
    public int compare(final String o1, final String o2) {
        if (Strings.isNullOrEmpty(o1)) {
            return -1;
        }

        if (Strings.isNullOrEmpty(o2)) {
            return 1;
        }

        if (o1.equals(o2)) {
            return 0;
        }

        int p1 = 0, p2 = 0;

        while (p1 < o1.length() && p2 < o2.length()) {
            if (Character.isDigit(o1.charAt(p1)) && Character.isDigit(o2.charAt(p2))) {
                break;
            }
            if (o1.charAt(p1) != o2.charAt(p2)) {
                return o1.charAt(p1) - o2.charAt(p2);
            }
            p1++;
            p2++;
        }

        if (p1 > o1.length()) {
            return -1;
        }

        if (p2 > o2.length()) {
            return 1;
        }

        int digit1 = getDigit(p1, o1);
        int digit2 = getDigit(p2, o2);

        return digit1 - digit2;
    }

    private int getDigit(int start, String s) {
        int p = start;
        while (p < s.length() && Character.isDigit(s.charAt(p))) {
            p++;
        }
        return Integer.parseInt(s.substring(start, p));
    }

    public static void main(String[] args) {
        String[] s = {"hello10s", "hello51", "what202", "hello10", "hello100", "hello0  10", ""};
        Arrays.sort(s, new CustomStringComparator());
        for (final String s1 : s) {
            System.out.println(s1);
        }
    }
}
