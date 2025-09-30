class Solution {
    public static int distSubseq(String s, String t, int i, int j, int[][] dp) {
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0, skip = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = distSubseq(s, t, i + 1, j + 1, dp);
        }
        skip = distSubseq(s, t, i+1, j, dp);

        return dp[i][j] = take + skip;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return distSubseq(s, t, 0, 0, dp);
    }
}