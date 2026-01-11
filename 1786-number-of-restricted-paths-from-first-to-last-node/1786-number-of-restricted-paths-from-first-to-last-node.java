class Solution {
    int mod = 1000000007;
    public int solve(List<List<int[]>> adj, int src, int n, int[] dist, int[] dp) {
        if(src == n){
            return 1;
        }
        if(dp[src] != -1){
            return dp[src];
        }

        int path = 0;
        for(int[] a:adj.get(src)){
            int neigh = a[0];
            if(dist[src] > dist[neigh]){
                path = (path + solve(adj, neigh, n, dist, dp)) % mod;
            }
        }
        return dp[src] = path;
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{n, 0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n]  =0;

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int curr = a[0];
            int d = a[1];
            if(dist[curr] < d){
                continue;
            }
            for(int[] arr:adj.get(curr)){
                int ng = arr[0];
                int dt = arr[1];
                if(dist[curr] + dt < dist[ng]){
                    dist[ng] = dist[curr] + dt;
                    pq.offer(new int[]{ng, dist[ng]});
                }
            }
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = solve(adj, 1, n, dist, dp);
        return ans;
    }
}