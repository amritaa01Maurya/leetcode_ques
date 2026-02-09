class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            int[] q = queries[i];
            int count = 0;
            int a = q[0] <= q[1] ? q[0] : q[1];
            int b = q[0] > q[1] ? q[0] : q[1];

            // a != b (until both have not same lca)
            while(a != b){
                if(b > a){
                    b /= 2;
                }
                else{
                    a /= 2;
                }
                count++;
            }

            ans[i] = count + 1;
        }
        return ans;
    }
}