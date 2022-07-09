package exercises.leetcode2001_2200;

/**
 * 2018. Check if Word Can Be Placed In Crossword
 */
public class CheckIfWordCanBePlacedInCrossword_2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    continue;
                }

                boolean horizontal = (j == 0 || board[i][j - 1] == '#') && (validHorizontal(board, i, j, word) || validHorizontal(board, i, j, reversedWord));
                boolean vertical = (i == 0 || board[i - 1][j] == '#') && (validVertical(board, i, j, word) || validVertical(board, i, j, reversedWord));
                if (horizontal || vertical) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validHorizontal(char[][] board, int i, int j, String word) {
        int pt = 0;
        int y = j;
        while (pt < word.length() && y < board[0].length) {
            if (board[i][y] == '#' || board[i][y] != ' ' && board[i][y] != word.charAt(pt)) {
                return false;
            }
            pt++;
            y++;
        }
        return pt >= word.length() && (y >= board[0].length || board[i][y] == '#');
    }

    private boolean validVertical(char[][] board, int i, int j, String word) {
        int pt = 0;
        int x = i;
        while (pt < word.length() && x < board.length) {
            if (board[x][j] == '#' || board[x][j] != ' ' && board[x][j] != word.charAt(pt)) {
                return false;
            }
            pt++;
            x++;
        }
        return pt >= word.length() && (x >= board.length || board[x][j] == '#');
    }
}
