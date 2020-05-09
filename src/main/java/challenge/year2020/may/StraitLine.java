package challenge.year2020.may;

public class StraitLine {
    /**
     * Created by Ruochen LI on 05/08/2020
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 1) return true;

        double y = coordinates[1][1] - coordinates[0][1];
        double x = coordinates[1][0] - coordinates[0][0];
        double pent = y / x;

        for (int i = 2; i < coordinates.length; i++) {
            double currentY = coordinates[i][1] - coordinates[0][1];
            double currentX = coordinates[i][0] - coordinates[0][0];
            double currentPent = currentY / currentX;
            if (currentPent != pent) return false;
        }

        return true;
    }
}
