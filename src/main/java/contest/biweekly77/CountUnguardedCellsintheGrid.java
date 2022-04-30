package contest.biweekly77;

import java.util.Arrays;

public class CountUnguardedCellsintheGrid {
    char[][] map;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int result = 0;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], 'e');
        }
        for (final int[] wall : walls) {
            map[wall[0]][wall[1]] = 'w';
        }

        for (final int[] guard : guards) {

            int startX = guard[0];
            int startY = guard[1];
            map[startX][startY] = 'g';

            // move up
            verticalMove(startX, startY, m, n, -1);

            // move down
            verticalMove(startX, startY, m, n, 1);

            // move right
            horizontalMove(startX, startY, m, n, 1);

            // move left
            horizontalMove(startX, startY, m, n, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'e') result++;
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        return result;
    }

    void verticalMove(int startX, int startY, int m, int n, int move){
        int px = startX + move;
        while (px >= 0 && px < m) {
            if (map[px][startY] == 'e') {
                map[px][startY] = 'v';
            } else if (map[px][startY] == 'v' || map[px][startY] == 'g' || map[px][startY] == 'w')
                break;
            px += move;
        }
    }

    void horizontalMove(int startX, int startY, int m, int n, int move){
        int py = startY + move;
        while (py >= 0 && py < n) {
            if (map[startX][py] == 'e') {
                map[startX][py] = 'h';
            } else if (map[startX][py] == 'h' || map[startX][py] == 'g' || map[startX][py] == 'w')
                break;
            py += move;
        }
    }
}
