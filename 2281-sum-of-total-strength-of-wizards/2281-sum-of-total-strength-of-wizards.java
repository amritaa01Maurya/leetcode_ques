class Solution {
    int mod = 1000000007;
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long sum = 0;
        long[] prefix = new long[n+1];
        long[] prefix2 = new long[n+2];

        for(int i=0;i<n;i++){
            prefix[i+1]= (prefix[i] + strength[i])%mod;
        }
        for(int i=0;i<=n;i++){
            prefix2[i+1]= (prefix2[i] + prefix[i])%mod;
        }
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && strength[i] <= strength[st.peek()]){
                st.pop();
            }
            left[i]= st.isEmpty()? -1:st.peek();
            st.push(i);
        }
        st.clear();
        int[] right = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && strength[i] < strength[st.peek()]){
                st.pop();
            }
            right[i]= st.isEmpty()? n:st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            int l = left[i];
            int r = right[i];
            long rSum = (prefix2[r+1] - prefix2[i+1] + mod)%mod;
            long lSum = (prefix2[i + 1] - prefix2[l + 1] + mod) %mod;

            long totSubSum = (rSum * (i - l) % mod - lSum * (r - i) % mod + mod) % mod;
        
            sum = (sum + strength[i] * totSubSum) % mod;
        }

        return (int)sum;
    }
}