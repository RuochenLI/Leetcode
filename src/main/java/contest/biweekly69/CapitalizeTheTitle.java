package contest.biweekly69;

public class CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        int left = 0;
        int right = 1;
        StringBuilder result = new StringBuilder();
        while (left < title.length() && right <= title.length()) {
            if (right == title.length() || title.charAt(right) == ' ') {
                if (right - left > 2) {
                    result.append(Character.toUpperCase(title.charAt(left)));
                } else {
                    result.append(Character.toLowerCase(title.charAt(left)));
                }
                for (int i = left + 1; i < right; i ++){
                    result.append(Character.toLowerCase(title.charAt(i)));
                }
                if (right != title.length() && left != right) result.append(Character.toLowerCase(title.charAt(right)));
                left = right + 1;
            }
            right++;
        }
        return result.toString();
    }
}
