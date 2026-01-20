class Solution {
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] leftMostIdx = new int[n]; // where ele is min
        int[] rightMostIdx = new int[n];//

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){//prev smaller ele
                st.pop();
            }
            leftMostIdx[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){//next smaller ele(use strict in one so that duplicate subarrays can not be count)
                st.pop();
            }
            rightMostIdx[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }

        long sum = 0;
        for(int i=0;i<n;i++){
            long leftSub = (i - leftMostIdx[i]) % mod;
            long rightSub = (rightMostIdx[i] - i) % mod;
            sum = (sum + arr[i] * (leftSub * rightSub)) % mod;
        }
        return (int)sum;
    }
}