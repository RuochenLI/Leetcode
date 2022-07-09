package exercises.leetcode201_400;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char digitS = secret.charAt(i);
            char digitG = guess.charAt(i);
            if (digitS == digitG) {
                bulls++;
            } else {
                if (count[digitS - '0'] < 0) {
                    cows++;
                }
                if (count[digitG - '0'] > 0) {
                    cows++;
                }
                count[digitS - '0']++;
                count[digitG - '0']--;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
