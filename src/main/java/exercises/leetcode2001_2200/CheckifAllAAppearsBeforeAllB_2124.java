package exercises.leetcode2001_2200;

public class CheckifAllAAppearsBeforeAllB_2124 {
    public boolean checkString(String s) {
        int pt = 0;
        while (pt < s.length() && s.charAt(pt) != 'b') {
            pt++;
        }

        for (int i = pt + 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(pt)) {
                return false;
            }
        }
        return true;
    }
}
