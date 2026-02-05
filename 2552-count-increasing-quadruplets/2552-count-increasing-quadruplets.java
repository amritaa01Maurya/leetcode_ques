class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;

//      i<j<k<l
//      nums[i] < nums[k] < nums[j] < nums[l]
//                   fix this k & j
//      find tot no. count which is less than nums[k] & its index (i) less than (j)
//      find tot no. count which is greater than nums[j] & its index (l)greater than (k)

        int[][] prefix = new int[n][n];// prefix[i][j] => b/w i and j => cal count of no. greater than nums[i]
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i+1;j<n;j++){// i < j
                if(nums[j] > nums[i]){
                    count++;
                }
                prefix[i][j] = count;
            }
        }


        int[][] suffix = new int[n][n];// suffix[i][j] => b/w i and j => cal count of no. smaller than nums[j]
        for(int i=n-1;i>=0;i--){
            int count = 0;
            for(int j=i-1;j>=0;j--){ // j < i
                if(nums[j] < nums[i]){
                    count++;
                }
                suffix[j][i] = count;
            }
        }

        long ans = 0;
        for(int j=1;j<n-2;j++){
            for(int k=j+1;k<n-1;k++){
                if(nums[j] > nums[k]){
                    int left = suffix[0][k] - suffix[j][k];// count of no. less than nums[k] & idx < j
                    int right = prefix[j][n-1] - prefix[j][k];// count of no. greater than nums[j] & idx > k

                    ans += left * right;
                }
            }
        }

        return ans;
    }
}