class Solution {
    public boolean found(char[][] board, String s, int idx, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if(idx == s.length()){
            return true;
        }
        
        if( i < 0 || j < 0 || i >= m || j >= n || board[i][j] != s.charAt(idx)){
            return false;
        } 
        char ch = board[i][j];
        board[i][j] = '#';
        boolean left = found(board, s, idx + 1, i, j-1);
        boolean right = found(board, s, idx + 1, i, j+1);
        boolean up = found(board, s, idx + 1, i-1, j);
        boolean down = found(board, s, idx + 1, i+1, j);
        board[i][j] = ch;

        return left || right || up || down;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(found(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
}