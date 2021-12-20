package leetcode.editor.cn;


public class BattleshipOnDeck {


    public int countBattleships(char[][] board) {
        int ans = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    if (i > 0 && board[i - 1][j] == 'X') ans--;
                    if (j > 0 && board[i][j - 1] == 'X') ans--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
