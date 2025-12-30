class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        
        for(int i =0;i<n;i++){
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] dir = {-1,0,1,0,-1};
        while(!q.isEmpty()){
            int[] arr = q.remove();
            int x = arr[0];
            int y = arr[1];
            for(int d=0;d<4;d++){
                int nx = x + dir[d];
                int ny = y + dir[d+1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || mat[nx][ny] != 1){
                    continue;
                }
                if(ans[nx][ny] > ans[x][y] + 1){
                    ans[nx][ny] = ans[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}