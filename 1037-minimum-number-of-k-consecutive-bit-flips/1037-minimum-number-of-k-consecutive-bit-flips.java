class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flip = 0;
        boolean[] flipped = new boolean[n];
        int tot_flip = 0;
        for(int i=0;i<n;i++){
            if(i >= k && flipped[i - k] == true){
                flip--; 
            }
            if(flip % 2 == nums[i]){
                if( i + k > n){
                    return -1;
                }
                flipped[i] = true;
                flip++;
                tot_flip++;
            }
        }
        return tot_flip;
    }
}