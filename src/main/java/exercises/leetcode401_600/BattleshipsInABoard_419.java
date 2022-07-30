package exercises.leetcode401_600;

/**
 * 419. Battleships in a Board
 */
public class BattleshipsInABoard_419 {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n = board[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;
            }
        }

        return count;
    }

    public int countBattleships1(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    board[i][j] = '.';
                    int pt = i + 1;
                    while (pt < board.length && board[pt][j] == 'X') {
                        board[pt][j] = '.';
                        pt++;
                    }
                    pt = j + 1;
                    while (pt < board[0].length && board[i][pt] == 'X') {
                        board[i][pt] = '.';
                        pt++;
                    }
                }
            }
        }

        return count;
    }
}
