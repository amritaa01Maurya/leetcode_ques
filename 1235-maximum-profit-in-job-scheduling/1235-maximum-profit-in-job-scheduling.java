class Solution {
    public int getIdx(int[][] arr, int l, int r, int currStart) {
        int idx = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid][1] <= currStart) {// prevend <= currstart
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);//sort on the basis of endtime

        int[] dp = new int[n];//max profit till ith job 
        dp[0] = arr[0][2];// max profit at 0th job

        for (int i = 1; i < n; i++) {
            int idx = getIdx(arr, 0, i - 1, arr[i][0]);// find max profit job from 0 to i - 1; which is non-overlapping to curr job

            // inc the curr job
            dp[i] = arr[i][2];
            if (idx != -1) {// if we found non-overlapping job with max profit
                dp[i] += dp[idx];
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}