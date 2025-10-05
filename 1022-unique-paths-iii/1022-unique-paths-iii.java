class Solution {
    public int uniquePath(int[][] grid, int i, int j, int count, int c) {
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || i >=n || j >= m || grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j] == 2){
            if(count == c - 1){
                return 1;
            }
            return 0;
        }

        int val = grid[i][j];
        grid[i][j] = -1;
        int left = uniquePath(grid, i, j + 1, count, c+1);
        int right = uniquePath(grid, i, j - 1, count, c+1);
        int up = uniquePath(grid, i-1, j, count, c+1);
        int down = uniquePath(grid, i+1, j, count, c+1);

        grid[i][j] = val;

        return left + right + up + down;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 0){
                    count++;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    return uniquePath(grid, i, j, count, 0);
                }
            }
        }
        return -1;
    }
}