class Solution {
    public boolean isPermutation(int[] arr){
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int m = s2.length();
        int[] freq = new int[26];
        for(int i=0;i<len;i++){
            freq[s1.charAt(i)-'a']++;
        }
        int l =0;
        for(int r=0;r<m;r++){
            freq[s2.charAt(r)-'a']--;
            while(r-l+1 > len){
                freq[s2.charAt(l)-'a']++;
                l++;
            }
            if(isPermutation(freq)){
                return true;
            }  
        }
        return false;
    }
}