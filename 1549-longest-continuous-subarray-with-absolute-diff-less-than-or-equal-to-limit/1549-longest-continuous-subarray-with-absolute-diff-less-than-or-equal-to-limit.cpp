class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        multiset<int> set;
        int l = 0;
        int maxLen = 0;
        for(int r=0;r<n;r++){
            set.insert(nums[r]);
            while(*set.rbegin() - *set.begin() > limit){
                set.erase(set.find(nums[l]));
                l++;
            }
            if( r - l + 1 > maxLen){
                maxLen = r - l + 1;
            }
            
        }
        return maxLen;
    }
};