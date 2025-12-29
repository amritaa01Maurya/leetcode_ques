class Solution {
    int tot = 0;
    public void solve(int[] nums, int i, int xor) {
        int n= nums.length;
        if(i >= n){
            tot += xor;
            return;
        }
        xor ^= nums[i];
        solve(nums, i + 1, xor);
        
        xor ^= nums[i];

        solve(nums, i + 1, xor);
        return;
    }
    public int subsetXORSum(int[] nums) {
        solve(nums, 0, 0);
        return tot;
    }
}