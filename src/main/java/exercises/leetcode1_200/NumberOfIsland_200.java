package exercises.leetcode1_200;

public class NumberOfIsland_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    colorMap(i, j, m, n, grid);
                }
            }
        }
        return count;
    }

    public void colorMap(int x, int y, int m, int n, char[][] grid) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != '1') return;

        grid[x][y] = '0';
        colorMap(x + 1, y, m, n, grid);
        colorMap(x - 1, y, m, n, grid);
        colorMap(x, y + 1, m, n, grid);
        colorMap(x, y - 1, m, n, grid);
    }

    public int numIslands1(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    colorMap(i, j, m, n, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void colorMap1(int x, int y, int m, int n, char[][] grid) {
        grid[x][y] ='0';

        if (x + 1 < m && grid[x + 1][y] == '1') {
            colorMap(x + 1, y, m, n, grid);
        }

        if (y + 1 < n && grid[x][y + 1] == '1') {
            colorMap(x, y + 1, m, n, grid);
        }

        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            colorMap(x, y - 1, m, n, grid);
        }

        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            colorMap(x - 1, y, m, n, grid);
        }
    }
}
