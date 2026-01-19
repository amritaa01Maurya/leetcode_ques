class Solution {
    int mod = 1000000007;
    int finalMask;
    public int solve(List<List<Integer>> people, int peopleMask, int hat, int[][] dp) {
        if(peopleMask == finalMask){ // all peoples are visited
            return 1;
        }
        
        if(hat > 40){
            return 0;
        }
        if(dp[hat][peopleMask] != -1){
            return dp[hat][peopleMask];
        }
        long ways = solve(people, peopleMask, hat + 1, dp); // skip 
        ways %= mod;
        for(int p: people.get(hat)){
            if(((peopleMask >> p) & 1) == 1){// already visited people
                continue;
            }
            ways = ways + solve(people, peopleMask | (1 << p), hat + 1, dp);
            ways %= mod;
        }

        return dp[hat][peopleMask]= (int)ways;
    }
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<List<Integer>> people = new ArrayList<>();
        for(int i=0;i<=40;i++){
            people.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int hat: hats.get(i)){
                people.get(hat).add(i);
            }
        }
        finalMask = (1 << n) - 1;
        int[][] dp = new int[41][finalMask + 1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(people, 0, 1, dp); // people, peopleMask, hat
    }
}