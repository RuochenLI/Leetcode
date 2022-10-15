package contest.biweekly89;

public class Exercise1 {
    public int countTime(String time) {
        char[] chars = time.toCharArray();
        char first = chars[0];
        char sec = chars[1];
        char third = chars[3];
        char fourth = chars[4];

        int countFourth = fourth == '?' ? 10 : 1;
        int countThird = third == '?' ? 6 : 1;
        int count = countFourth * countThird;
        if (first == '?' && sec == '?') {
            return 24 * count;
        }

        if ((first == '0' || first == '1') && sec == '?') {
            return 10 * count;
        }

        if (first == '2' && sec == '?') {
            return 4 * count;
        }

        if (first == '?' && sec > '3') {
            return 2 * count;
        }

        if (first == '?') {
            return 3 * count;
        }

        return count;
    }
}
