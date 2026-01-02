class Solution {
    public int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int l = 0;
        int h = 1000000;
        int ans = 0;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(bfs(arr, mid)){
                h = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean bfs(int[][] arr, int reqEff) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> pq = new LinkedList<>();
        int[][] vis = new int[n][m];

        int[] dir = {-1,0, 1, 0 ,-1};
        pq.add(new int[]{0, 0}); // i, j
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int i = a[0];
            int j = a[1];
            if(vis[i][j] == 1)continue;
            if(i == n - 1 && j == m - 1){
                return true;
            }
            vis[i][j] = 1;
            for(int d=0;d<4;d++){
                int ni = i + dir[d];
                int nj = j + dir[d+1];
                if(ni < 0 || nj < 0 || ni >= n || nj >= m || Math.abs(arr[i][j] - arr[ni][nj]) > reqEff || vis[ni][nj] == 1){
                    continue;
                }

                pq.offer(new int[]{ni, nj});
            }
        }
        return false;
    }
}