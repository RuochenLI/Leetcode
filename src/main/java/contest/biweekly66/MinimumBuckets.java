package context.biweekly66;

public class MinimumBuckets {
    public int minimumBuckets(String street) {
        if (!street.contains("H")) {
            return 0;
        }

        if (!street.contains(".")
                || street.contains("HHH")
                || street.startsWith("HH")
                || street.endsWith("HH")) {
            return -1;
        }

        int ans = 0;
        boolean[] marks = new boolean[street.length() + 2];
        for (int i = 0; i < street.length(); i++) {
            marks[i] = street.charAt(i) == 'H';
        }
        for (int i = 1; i <= street.length(); i++) {
            if (!marks[i] && marks[i - 1]) {
                ans++;
                marks[i + 1] = false;
            } else if (i > 1 && marks[i] && marks[i -1] && !marks[i + 1]) {
                ans += 2;
                marks[i + 2] = false;
                i += 2;
            }
        }
        return ans;
    }
}
