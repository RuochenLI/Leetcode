package mayChallenge2020;

public class FirstuniqueCharacterInString {

    /*
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
    Note: You may assume the string contain only lowercase letters.
     */
    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (final char c : chars) {
            hash[c]++;
        }

        for (int index = 0; index < chars.length; index++) {
            if (hash[chars[index]] == 1) return index;
        }

        return -1;
    }
}
