package contest.biweekly69;

public class LongestPalindromeByConcatenatingTwoLettersWord {
//    public int longestPalindrome(String[] words) {
//        boolean[] mark = new boolean[words.length];
//        boolean flag = false;
//        int result = 0;
//        for (int i = 0; i < words.length; i++) {
//            if (!mark[i]) {
//                int pointer = i + 1;
//                boolean found = false;
//                while (pointer < words.length && !found) {
//                    if (!mark[pointer] && words[i].charAt(0) == words[pointer].charAt(1) && words[i].charAt(1) == words[pointer].charAt(0)) {
//                        result += 4;
//                        found = true;
//                        mark[pointer] = true;
//                    }
//                    pointer++;
//                }
//                if (!found &&  words[i].charAt(0) ==  words[i].charAt(1) && !flag) {
//                    result += 2;
//                    flag = true;
//                }
//            }
//        }
//        return result;
//    }
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        int countDouble = 0;
        int result = 0;
        for (String word : words) {
            char first = word.charAt(0);
            char sec = word.charAt(1);
            if (count[sec - 'a'][first - 'a'] > 0) {
                count[sec - 'a'][first - 'a']--;
                if (first == sec) countDouble--;
                result += 4;
            } else {
                count[first - 'a'][sec - 'a']++;
                if (first == sec) countDouble++;
            }
        }
        if (countDouble > 0) result += 2;
        return result;
    }
}
