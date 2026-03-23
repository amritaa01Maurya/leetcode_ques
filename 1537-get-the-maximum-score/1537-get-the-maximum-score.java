class Solution {
    int mod = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i =0;
        int j = 0;
        long sum1 = 0;
        long sum2 = 0;
        long ans = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                sum1 = (sum1 + nums1[i]);
                i++;
            }else if(nums1[i] > nums2[j]){
                sum2 = (sum2 + nums2[j]);
                j++;
            }else{
                ans = (ans + Math.max(sum1, sum2) + nums1[i]) % mod;// nums1[i] == nums2[j];//so till max + same ele in both
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        // if ther are rem ele in nums1 or nums2
        while(i < n){
            sum1 = (sum1 + nums1[i++]);
        }
        while(j < m){
            sum2 = (sum2 + nums2[j++]);
        }
        ans = (ans + Math.max(sum1, sum2)) % mod;
        return (int)ans;
    }
}