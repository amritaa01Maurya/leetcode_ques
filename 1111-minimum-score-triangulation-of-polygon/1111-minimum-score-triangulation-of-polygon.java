class Solution {
    public int minScore(int[] values, int i, int j, int[][] dp) {
        if(i + 1 == j){
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min_score = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int part1 = minScore(values, i, k, dp);
            int part2 = minScore(values, k, j, dp);
            int weight = values[i] * values[k] * values[j];
            min_score = Math.min(min_score, part1 + part2 + weight);
        }
        return dp[i][j] = min_score;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return minScore(values, 0, n - 1, dp);
    }
}