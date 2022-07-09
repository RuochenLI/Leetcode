package exercises.leetcode801_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord_843 {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
            String guess = wordlist[random.nextInt(wordlist.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String word : wordlist) {
                if (matches == getMatches(guess, word)) {
                    candidates.add(word);
                }
            }

            wordlist = candidates.toArray(new String[0]);
        }
    }

    private int getMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }

        return matches;
    }

    interface Master {
        int guess(String word);
    }
}
