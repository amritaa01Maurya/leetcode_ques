class Solution {
    class DS{
        int[] par, rank;
        public DS(int n){    
            par = new int[n];
            rank = new int[n];
        
            for(int i=0;i<n;i++){
                par[i] = i;
            }
        }

        public int find(int a){
            if(a == par[a]){
                return a;
            }
            return par[a] = find(par[a]);
        }

        public void union(int a, int b){
            int para = find(a);
            int parb = find(b);
            if(rank[para] == rank[parb]){
                par[parb] = para;
                rank[para]++;
            }else if(rank[para] > rank[parb]){
                par[parb] = para;
            }else{
                par[para] = parb;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DS ds = new DS(n);

        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                ds.union(i, i-1);
            }
        }

        boolean[] path = new boolean[queries.length];
        int idx = 0;
        for(int i=0;i<queries.length;i++){
            int para = ds.find(queries[i][0]);
            int parb = ds.find(queries[i][1]);

            if(para == parb){
                path[idx] = true;
            }else{
                path[idx] = false;
            }
            idx++;
        }
        return path;
    }
}