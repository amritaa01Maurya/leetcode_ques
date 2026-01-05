class Solution {
    public int solve(List<Integer> list, int i, int num, int l, int[][] dp) {
        if(i >= list.size() || num < 0){
            return Integer.MAX_VALUE;
        }
        if(num == 0){
            return l;
        }
        if(dp[i][num] != -1){
            return dp[i][num];
        }
        int inc1 = solve(list, i, num - list.get(i), l + 1, dp);
        int inc2 = solve(list, i + 1, num - list.get(i), l + 1, dp);
        int exc = solve(list, i+1, num, l, dp);

        return dp[i][num] = Math.min(Math.min(inc1, inc2), exc);
    }
    public int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
        if(k == 0){
            return num % 10 == 0 ? 1: -1;
        }
        List<Integer> l = new ArrayList<>();
        int val = k;
        l.add(val);
        while(val <= num){
            val += 10;
            l.add(val);
        }
        int[][] dp = new int[l.size()][num+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        int ans = solve(l, 0, num, 0, dp);
        return ans == Integer.MAX_VALUE ?  -1: ans; 
    }
}