class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Stack<int[]> st = new Stack<>();
        int maxStep = 0;
        for(int i=n-1;i>=0;--i){
            int step = 0;
            while(!st.isEmpty() && nums[st.peek()[0]] < nums[i]){//if top less than curr, pop it
                step++;
                step = Math.max(step, st.peek()[1]);
                st.pop();
            }
            maxStep = Math.max(maxStep, step);
            st.push(new int[]{i, step});
        }
        return maxStep;
    }
}