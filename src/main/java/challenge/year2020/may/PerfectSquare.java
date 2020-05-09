package challenge.year2020.may;

public class PerfectSquare {
    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     *
     * Note: Do not use any built-in library function such as sqrt.
     *
     * Example 1:
     *
     * Input: 16
     * Output: true
     * Example 2:
     *
     * Input: 14
     * Output: false
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        return findPerfectSquare(1, num / 2, num);
    }

    private static boolean findPerfectSquare(final int start, final int end, final int target) {
        if (end * end == target) {
            return true;
        }
        if (start >= end)
            return false;

        int medium = start + (end - start) / 2;
        if ((long) medium * medium < target) {
            return findPerfectSquare(medium + 1, end, target);
        } else {
            return findPerfectSquare(start, medium, target);
        }
    }
}
