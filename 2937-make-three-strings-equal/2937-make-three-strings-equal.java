class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int  ans = 0;
        int i =0;
        int j=0;
        int k=0;
        int len = 0;
        while(i < s1.length() && j < s2.length() && k < s3.length() && s1.charAt(i) == s2.charAt(j)  && s1.charAt(i) == s3.charAt(k)){
            len++;
            i++;
            j++;
            k++;
        }
        if(len == 0){
            return -1;
        }
        ans = s1.length() + s2.length() + s3.length() - 3 * len;
        return ans;
    }
}