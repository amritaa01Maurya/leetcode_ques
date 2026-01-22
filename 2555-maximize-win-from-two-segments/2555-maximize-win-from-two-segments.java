class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int maxPrizes = 0;
        int l = 0;
        int[] max = new int[n];
        for(int r=0;r<n;++r){
            while(prizePositions[r] - prizePositions[l] > k){
                l++;
            }
            
            max[r] = r - l + 1;
            if(r > 0)
            max[r] = Math.max(max[r-1], r - l + 1);//max window till l to r

            int prevMax = l > 0 ? max[l-1]:0; // prev max window till l - 1;
            maxPrizes = Math.max(maxPrizes, r-l+1 + prevMax); // prevmax + currMax
        }
        return maxPrizes;
    }
}