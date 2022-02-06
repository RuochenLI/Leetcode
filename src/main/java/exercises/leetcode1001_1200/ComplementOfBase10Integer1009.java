package exercises.leetcode1001_1200;

public class ComplementOfBase10Integer1009 {
    public int bitwiseComplement(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] chars = binaryString.toCharArray();
        StringBuilder resultBuilder = new StringBuilder();
        for (final char c : chars) {
            resultBuilder.append(c == '0' ? '1' : '0');
        }
        String result = resultBuilder.toString();
        return Integer.parseInt(result, 2);
    }
}
