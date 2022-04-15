package exercises.leetcode1_200;

public class WordSearch_79 {
    int[][] MOVE = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] status = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(0)) {
                    status[i][j] = true;
                    boolean found = search(board, status, i, j, 1, word);
                    if (found) return true;
                    status[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean search(final char[][] board, final boolean[][] status, final int x, final int y, final int pointer, final String word) {
        if (pointer >= word.length()) {
            return true;
        }

        for (final int[] move : MOVE) {
            int moveX = x + move[0];
            int moveY = y + move[1];
            if (moveX >= 0 &&
                moveX < board.length &&
                moveY >= 0 &&
                moveY < board[0].length &&
                !status[moveX][moveY] &&
                board[moveX][moveY] == word.charAt(pointer)) {
                status[moveX][moveY] = true;
                boolean found = search(board, status, moveX, moveY, pointer + 1, word);
                if (found) return true;
                status[moveX][moveY] = false;
            }
        }

        return false;
    }
}
