class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0;
        for(int j =0;j<n;j++){
            ans[i++] = nums[j];
            ans[i++] = nums[j+n];
        }
        return ans;
    }
}