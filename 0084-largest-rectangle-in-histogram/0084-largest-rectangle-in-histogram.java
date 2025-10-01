class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++){
            int val = i == n ? 0 : arr[i];
            while(!st.isEmpty() && val < arr[st.peek()]){
                int nextSmallerRight = i;
                int curr = arr[st.pop()];
                int nextSmallerLeft = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, curr * ( nextSmallerRight - nextSmallerLeft - 1));
            }
            st.push(i);
        }
        return maxArea;
    }
}