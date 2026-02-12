class Solution {
    public boolean isBalanced(int[] arr) {
        int f = 0;
        for(int a: arr){
            // if freq is greater than 0
            if(a > 0){
                if(f == 0){
                    f = a;
                }else if( a != f){// check all char freq is same or not
                        return false;
                }
            }
        }
        return true;
    }
    
    public int longestBalanced(String s) {
        int len = 0;
        // check for all substring
        for(int l=0;l<s.length();l++){
            int[] freq = new int[26];
            for(int r=l;r<s.length();r++){
                freq[s.charAt(r) - 'a']++;
                if(isBalanced(freq)){
                    len = Math.max(len, r - l + 1);
                }
            }
        }
        return len;
    }
}