class Solution {
public:
    int minDistance(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for(int i=0;i<=m;i++){
            dp[0][i] = i;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1[i-1] == word2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int delCharW1 = dp[i-1][j];
                    int repChar = dp[i-1][j-1];
                    int insChar = dp[i][j-1];

                    dp[i][j] = 1 + min({delCharW1, repChar, insChar});
                }
            }
        }
        return dp[n][m];
    }
};