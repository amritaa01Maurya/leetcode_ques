class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i= n - 1;i >= 0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1:nums[st.peek()];

            st.push(i);
        }
        for(int i= n - 1;i >= 0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1:nums[st.peek()];

            st.push(i);
        }
        return ans;
    }
}