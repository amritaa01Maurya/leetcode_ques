class Solution {
    int mod = 1000000007;
    public int BS1(int[] nums, int l, int r, int val) {
        int idx = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] <= val){//greatest but smaller = than val
                idx = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return idx;
    }

    public int BS2(int[] nums, int l, int r, int val) {
        int idx = r + 1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] > val){// smallest greater than  val
                idx = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return idx;
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        int[] temp = nums1.clone();
        Arrays.sort(temp);

        long ans = sum;

        for(int i=0;i<n;i++){
            int idx = BS1(temp, 0, n - 1, nums2[i]);
            int idx2 = BS2(temp, 0, n - 1, nums2[i]);

            long oldDiff = Math.abs(nums1[i] - nums2[i]);

            if(idx > -1){
                long newDiff = Math.abs(temp[idx] - nums2[i]);
                ans = Math.min(ans , sum + newDiff - oldDiff);

            }
            if(idx2 < n){
                long newDiff = Math.abs(temp[idx2] - nums2[i]);
                ans = Math.min(ans , sum + newDiff - oldDiff);
            }
            
        }

        ans %= mod;
        return (int)ans;
    }
}