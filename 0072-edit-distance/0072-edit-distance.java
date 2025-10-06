class Solution {
    public int min(String word1, String word2, int i, int j, int[][] dp) {
        int n = word1.length();
        int m = word2.length();
        if(i == n){
            return word2.length() - j;
        } 
        if(j == m){
            return word1.length() - i;
        }
        
        if(word1.charAt(i) == word2.charAt(j)){
            return min(word1, word2, i+1, j+1, dp);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int insert = min(word1, word2, i, j+1, dp);
        int delete =  min(word1, word2, i+1, j, dp);
        int replace = min(word1, word2, i+1, j+1, dp);

        return  dp[i][j] = 1 + Math.min(insert,Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return min(word1, word2, 0, 0, dp);
    }
}