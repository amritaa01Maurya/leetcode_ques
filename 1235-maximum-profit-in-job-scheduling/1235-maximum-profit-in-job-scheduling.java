class Solution {
    public int getIdx(int[][] arr, int i, int currstart) {
        int l = 0;
        int h = i - 1;
        int idx = -1;
        while(l <= h){
            int mid = (l + h)/2;
            if(arr[mid][1] <= currstart){
                idx = mid;
                l = mid+1;
            }else{
                h = mid - 1;
            }
        }
        return idx;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a,b)-> a[1] - b[1]);

        int[] dp = new int[n];
        dp[0] = arr[0][2];
        for(int i=1;i<n;i++){
            int non_overlap = getIdx(arr, i, arr[i][0]);
            
            int inc = arr[i][2];
            if(non_overlap != -1){
                inc = inc + dp[non_overlap];
            }
            
            dp[i] = Math.max(inc, dp[i-1]);
        }
        return dp[n-1];
    }
}