package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int pt = 0;

        while (pt < words.length) {
            List<String> currentRowWords = new ArrayList<>();
            currentRowWords.add(words[pt]);
            int currentCount = words[pt].length();
            while (pt < words.length - 1 && currentCount + words[pt + 1].length() + 1 <= maxWidth) {
                pt++;
                currentCount = currentCount + words[pt].length() + 1;
                currentRowWords.add(words[pt]);
            }
            StringBuilder row = new StringBuilder();
            if (currentRowWords.size() == 1 || pt == words.length - 1) {
                row = new StringBuilder(String.join(" ", currentRowWords) + " ".repeat(maxWidth - currentCount));
            } else {
                int remaining = maxWidth - currentCount;
                int avgSpace = remaining / (currentRowWords.size() - 1);
                int mod = remaining % (currentRowWords.size() - 1);
                for (int i = 0; i < currentRowWords.size() - 1; i++){
                    int nbSpace = avgSpace + 1;
                    if (mod > 0) {
                        nbSpace++;
                        mod--;
                    }
                    row.append(currentRowWords.get(i)).append(" ".repeat(nbSpace));
                }
                row.append(currentRowWords.get(currentRowWords.size() - 1));
            }
            result.add(row.toString());
            pt++;
        }

        return result;
    }
}
