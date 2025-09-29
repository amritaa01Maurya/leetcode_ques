class Solution {
    public int max_area(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] l = new int[arr.length];
        int[] r = new int[arr.length];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            l[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();

        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            r[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea, arr[i] * ( r[i] - l[i] - 1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[j]++;
                }else{
                    arr[j]=0;
                }
            }
            ans = Math.max(ans, max_area(arr));
        }
        return ans;
    }
}