class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0,1},{0, -1}};
    int n;
    int m;
    public boolean isSafe(int r, int c) {
        if(r < 0 || c < 0 || r >= n || c >= m){
            return false;
        }
        return true;
    }
    public boolean canGoAt(int[][] heights, int r, int c, boolean[][] vis) {
        if(r == n-1 || c == m - 1 ){
            return true;
        }
        vis[r][c] = true;
        boolean go = false;
        for(int[] d: dir){
            int i = r + d[0];
            int j = c + d[1];
            if(isSafe(i,j) && !vis[i][j] && heights[i][j] <= heights[r][c]){
                go |= canGoAt(heights, i, j, vis);
            }
        }
        return go;
    }

    public boolean canGoPc(int[][] heights, int r, int c, boolean[][] vis) {
        if(r == 0 || c == 0){
            return true;
        }
        vis[r][c] = true;
        boolean go = false;
        for(int[] d: dir){
            int i = r + d[0];
            int j = c + d[1];
            if(isSafe(i,j) && !vis[i][j] && heights[i][j] <= heights[r][c]){
                go |= canGoPc(heights, i, j, vis);
            }
        }
        return go;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       n = heights.length;
        m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();;
        int[][] dp = new int[n][m];
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                boolean[][] vis = new boolean[n][m];
                boolean[][] vis2 = new boolean[n][m];
                if(canGoAt(heights, i, j,vis) && canGoPc(heights, i, j, vis2)){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans; 
    }
}