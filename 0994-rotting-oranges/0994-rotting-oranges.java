class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        if(q.isEmpty()){
            return -1;
        }
        int[] dirs = {-1,0,1,0,-1};
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int prev = fresh;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int d=0;d<4;d++){
                    int nx = curr[0] + dirs[d];
                    int ny = curr[1] + dirs[d+1];

                    if( nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 1){
                        continue;
                    }
                    grid[nx][ny] = 2;
                    fresh--;
                    q.offer(new int[]{nx, ny});
                }
            }
            if(fresh < prev) time++;
        }
        return fresh > 0 ? -1 : time;
    }
}