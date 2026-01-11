class Solution {
    public int minLength(int[] nums, int k) {
        int l =0;
        int n = nums.length;
        int ans = n + 1;
        int sum = 0;
        Map<Integer, Integer> map =new HashMap<>();
        
        for(int r=0;r<n;r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            
            if(map.get(nums[r]) == 1){
                sum += nums[r];
            }
            
            while(sum >= k){
                ans = Math.min(ans, r - l + 1);
                map.put(nums[l], map.get(nums[l])-1);

                if(map.get(nums[l]) == 0){
                    sum -= nums[l];
                    map.remove(nums[l]);
                }
                l++;
            }
        }
        return ans > n ? -1 : ans;
    }
}