class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n =nums.size();
        vector<int> dp;
        for(int i=0;i<n;i++){
            int x = nums[i];

            int idx = lower_bound(dp.begin(), dp.end(), x) - dp.begin();

            if(idx == dp.size()){
                dp.push_back(x);
            }else{
                dp[idx] = x;
            }
        }
        return dp.size();
    }
};