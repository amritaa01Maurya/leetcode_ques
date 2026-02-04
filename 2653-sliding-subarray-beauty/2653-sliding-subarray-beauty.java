class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        int[] freq = new int[51];// -50 to -1 only range for -ve
        int l= 0;
        int idx = 0;
        for(int r=0;r<n;r++){

            // count the freq of each -ve no.
            if(nums[r] < 0){
                freq[(-1)*nums[r]]++;
            }

            // shrink the window 
            while(r - l + 1 > k){
                if(nums[l] < 0){
                    freq[(-1)*nums[l]]--;
                }
                l++;
            }
            
            // if window size == k
            if(r - l + 1 == k){
                int c = 0;
                for(int i=50;i>=1;i--){// xth smallest -50, -49,....-1
                    c += freq[i];
                    if(c >= x){
                        ans[idx++] = -i;
                        break;
                    }
                }
                if(c < x){// less than x  -ve no.
                    ans[idx++] = 0;
                }
            }
        }
        return ans;
    }
}