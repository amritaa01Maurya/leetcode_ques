class Solution {
    public List<String> Display(boolean[][] board) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            l.add(sb.toString());
        }
        return l;
    }

    public void solve(boolean[][] board, int row, int tq, List<List<String>> ll) {
        if (tq == 0) {
            ll.add(Display(board));
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;
                solve(board, row + 1, tq - 1, ll);
                board[row][col] = false;
            }
        }
    }

    public boolean isItSafe(boolean[][] board, int row, int col) {
        int r = row;

        while (r >= 0) {
            if (board[r][col]) {
                return false;
            }
            r--;
        }


        r = row;
        int c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }


        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ll = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solve(board, 0, n, ll);

        return ll;
    }
}