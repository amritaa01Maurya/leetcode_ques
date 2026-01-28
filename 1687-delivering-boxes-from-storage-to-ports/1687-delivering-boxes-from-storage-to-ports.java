class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int l = 0;

        int[] dp = new int[n+1];
        dp[0]= 0;

        int[] portChange = new int[n];
        int count = 0;
        for(int i=1;i < n;i++){
            if(boxes[i-1][0] != boxes[i][0]){
                count++;
            }
            portChange[i] = count;
        }
        int wt = 0;

        for(int r=0;r<n;r++){
            wt += boxes[r][1];

            while(r - l + 1 > maxBoxes || wt > maxWeight){//if boxes number exceeded or wt exceeded
                wt -= boxes[l][1];
                l++;
            }

            while( l < r && dp[l] == dp[l+1]){
                wt -= boxes[l][1];
                l++;
            }

            dp[r+1] = portChange[r] - portChange[l] + 2 + dp[l];// here 2 is req 
        }
        return dp[n];
    }
}