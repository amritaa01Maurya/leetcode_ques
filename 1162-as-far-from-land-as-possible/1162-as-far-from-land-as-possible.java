class Solution {
    public int maxDistance(int[][] grid) {
        int n= grid.length;
        Queue<int[]> q = new LinkedList<>();
        // add all land pos in queue
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        if(q.isEmpty()){// if no land is there return -1
            return -1;
        }
        int[] dirs = {-1,0,1,0,-1};
        int dist = -1;

        while(!q.isEmpty()){
            int[] a = q.poll();
            int x = a[0];
            int y = a[1];
            int dis = a[2];

            for(int d=0;d<4;d++){
                int nx = x + dirs[d];
                int ny = y + dirs[d+1];

                if( nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx][ny] != 0){
                    continue;
                }
                // change water to land so that we do not visit again
                grid[nx][ny] = 1;
                q.offer(new int[]{nx, ny, dis + 1});
                dist = Math.max(dis + 1, dist);
            }
        }
        return dist;
    }
}