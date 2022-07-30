package exercises.leetcode601_800;

/**
 * 794. Valid Tic-Tac-Toe State
 */
public class ValidTicTacToeState {
    private final char[][] gameBoard = new char[3][3];

    public boolean validTicTacToe(String[] board) {

        unpackBoard(board);

        return gameBoardValidation();
    }

    private void unpackBoard(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.gameBoard[i][j] = board[i].charAt(j);
            }
        }
    }

    private boolean gameBoardValidation() {

        int numX, numO;

        numX = count('X');
        numO = count('O');

        //X goes first
        if (numO > numX) {
            return false;
        }

        //players take turns
        if (numX > numO + 1) {
            return false;
        }

        //both players can't win
        if (winner('X') && winner('O')) {
            return false;
        }

        //game ends when one player wins
        if (winner('X') && numX == numO) {
            return false;
        }

        //game ends when one player wins
        return !winner('O') || numX <= numO;
    }

    private int count(char player) {

        int num = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == player) {
                    num++;
                }
            }
        }

        return num;
    }

    private boolean winner(char player) {

        if (validateRows(player)) {
            return true;
        }
        if (validateColumns(player)) {
            return true;
        }
        return validateDiagonal(player);
    }

    private boolean validateRows(char player) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == player && gameBoard[i][1] == player && gameBoard[i][2] == player) {
                return true;
            }
        }

        return false;
    }

    private boolean validateColumns(char player) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[0][i] == player && gameBoard[1][i] == player && gameBoard[2][i] == player) {
                return true;
            }
        }

        return false;
    }

    private boolean validateDiagonal(char player) {
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }
        return gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player;
    }

    /*
    When turns is 1, X moved. When turns is 0, O moved. rows stores the number of X or O in each row. cols stores the number of X or O in each column. diag stores the number of X or O in diagonal. antidiag stores the number of X or O in antidiagonal. When any of the value gets to 3, it means X wins. When any of the value gets to -3, it means O wins.

When X wins, O cannot move anymore, so turns must be 1. When O wins, X cannot move anymore, so turns must be 0. Finally, when we return, turns must be either 0 or 1, and X and O cannot win at same time.
     */
    public boolean validTicTacToe1(String[] board) {
        int turns = 0;
        boolean xwin = false;
        boolean owin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++; rows[i]++; cols[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--; rows[i]--; cols[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
               cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
               diag == 3 || antidiag == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
               cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
               diag == -3 || antidiag == -3;

        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }
}
