package exercises;

public class LongestSubString {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        if (s.length() == 1 && k == 1) return 1;
        int[] count = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            pos[c - 'a'] = i;
        }
        int mid = -1;
        boolean allLessThanK = true;
        for (int pointer = 0; pointer < 26; pointer++) {
            if (count[pointer] == 0) continue;
            if (count[pointer] < k) {
                mid = pos[pointer];
            } else {
                allLessThanK = false;
            }
        }
        if (allLessThanK) return 0;
        if (mid == -1) return s.length();
        if (mid == 0) return longestSubstring(s.substring(mid + 1), k);
        if (mid == s.length() - 1) return longestSubstring(s.substring(0, mid), k);
        return Math.max(longestSubstring(s.substring(0, mid), k), longestSubstring(s.substring(mid + 1), k));
    }
}
