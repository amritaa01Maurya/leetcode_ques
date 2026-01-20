class Solution {
    public long subCount(int l, int r, int k) {
        int totLen = l + r - 1;
        long totSubCount = l * r;
        long extraSub = Math.max(0, totLen - k);
        long extraSubCount = extraSub * (extraSub + 1)/2;

        return totSubCount - extraSubCount;
    }
    public long minMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] leftMostIdxMin = new int[n]; // where ele is min
        int[] rightMostIdxMin = new int[n];//

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]){//prev smaller ele
                st.pop();
            }
            leftMostIdxMin[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){//next smaller ele(use strict in one so that duplicate subarrays can not be count)
                st.pop();
            }
            rightMostIdxMin[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        st.clear();
        int[] leftMostIdxMax = new int[n]; // where ele is max
        int[] rightMostIdxMax = new int[n];//

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){//prev greater ele
                st.pop();
            }
            leftMostIdxMax[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){//next greater ele(use strict in one so that duplicate subarrays can not be count)
                st.pop();
            }
            rightMostIdxMax[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        long ans = 0;
        for(int i=0;i<n;++i){
            ans  += nums[i] * subCount(Math.min(i - leftMostIdxMin[i], k), Math.min(rightMostIdxMin[i] - i, k), k); // count no. of subarrays <= k where i is min
            ans += nums[i] * subCount(Math.min(i - leftMostIdxMax[i], k), Math.min(rightMostIdxMax[i] - i, k), k);

        }
        return ans;
    }
}