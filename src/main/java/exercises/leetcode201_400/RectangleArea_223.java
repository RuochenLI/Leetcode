package exercises.leetcode201_400;

public class RectangleArea_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int common;
        if (ax2 < bx1 || bx2 < ax1 || ay2 < by1 || by2 < ay1) {
            common = 0;
        } else {
            int distanceX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
            int distanceY = Math.min(ay2, by2) - Math.max(ay1, by1);
            common = Math.abs(distanceX * distanceY);
        }
        int areaA = Math.abs((ay2 - ay1) * (ax2 - ax1));
        int areaB = Math.abs((by2 - by1) * (bx2 - bx1));

        return areaB + areaA - common;
    }
}
