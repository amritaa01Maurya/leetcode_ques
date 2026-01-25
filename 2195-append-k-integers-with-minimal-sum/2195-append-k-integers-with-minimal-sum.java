class Solution {
    public long nthSum(long n) {
        return n *(n+1)/2;
    }
    public long minimalKSum(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        long prev = 0;
        int idx = 0;
        while(k > 0 && idx < n){
            if(nums[idx] == prev){// skip duplicates
                idx++;
                continue;
            }
            long gap = Math.min(nums[idx] - prev - 1, k);

            sum += (nthSum(prev + gap) - nthSum(prev));

            k -= gap;
            prev = nums[idx];
            if(k == 0){
                break;
            }
            idx++;
        }

        if(k > 0){
            sum += nthSum(prev + k) - nthSum(prev);
            k = 0;
        }
        return sum;
    }
}