package exercises.leetcode1201_1400;

public class FindWinnerOnTicTacToeGame_1275 {
    public String tictactoe(int[][] moves) {
        int[][] row = new int[2][3], col = new int[2][3];
        int[] d1 = new int[2], d2 = new int[2];
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1], id = i % 2;
            if (++row[id][r] == 3 || ++col[id][c] == 3 || r == c && ++d1[id] == 3 || r + c == 2 && ++d2[id] == 3)
                return id == 0 ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
