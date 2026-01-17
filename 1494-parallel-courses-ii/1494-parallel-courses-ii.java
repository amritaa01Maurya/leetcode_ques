class Solution {
    public int solve(int n, int mask, List<List<Integer>> adj, int[] dp, int k){
        if(mask == (1 << n) - 1){
            return 0; // all nodes visited
        }

        if(dp[mask] != -1){
            return dp[mask];
        }
        int[] indeg = new int[n];
        for(int i=0;i<n;i++){
            if((mask & (1 << i)) == (1 << i)){ // if prev course taken
                continue;
            }
            for(int neigh:adj.get(i)){
                indeg[neigh]++;
            }
        }

        int availMask = 0; // courses available
        for(int i=0;i<n;i++){
            if(indeg[i] == 0 && (mask & (1 << i)) == 0){// i is not taken
                availMask |= (1 << i);
            }
        }
        int  count = Integer.bitCount(availMask);
        int sem = Integer.MAX_VALUE; // max we can take infinity semester
        if(count > k){ // best min sem combination (check submask of available mask)

            for(int i=availMask; i > 0; i = (i-1) & availMask){
                if(Integer.bitCount(i) == k){ 
                    sem = Math.min(sem, 1 + solve(n, mask | i, adj, dp, k));
                }
            }
        }else{ // take all available course
            sem = Math.min(sem, 1 + solve(n, mask | availMask, adj, dp, k));
        }

        return dp[mask] = sem;
    }
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] rel:relations){
            int u = rel[0] - 1; // node from 0
            int v = rel[1] - 1;
            adj.get(u).add(v);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);

        return solve(n, 0, adj, dp, k); // no course is selected 
    }
}