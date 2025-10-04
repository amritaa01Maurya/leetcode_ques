class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int k = n/4;
        int[] freq = new int[128];
        for(char ch: s.toCharArray()){
            freq[ch - 'A']++;
        }
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            freq[ch - 'A']--;
            while(l < n && freq['Q' - 'A'] <= k && freq['W' - 'A'] <= k && freq['E' - 'A'] <= k && freq['R' - 'A'] <= k){
                ch = s.charAt(l);
                minLen = Math.min(minLen, r - l + 1);
                freq[ch - 'A']++;
                l++;
            }
        }
        return minLen;
    }
}