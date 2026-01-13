class Solution {
    public int largestPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int sum = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                sum += i;
            }
            if(sum > n){
                break;
            }
            st.push(sum);
        }

        while(!st.isEmpty()){
            int res = st.pop();
            if(prime[res]){
                return res;
            }
        }
        return 0;
    }
}