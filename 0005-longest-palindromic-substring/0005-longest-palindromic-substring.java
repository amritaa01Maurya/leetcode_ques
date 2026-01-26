class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        for (int r = 0; r < n; r++) {
            dp[r][r] = true;// string of length one is palin
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && ((r - l) < 2 || dp[l + 1][r - 1] == true)) {// if l and r mathes, is string b/w them are palind or not (or if length b/w them is 1 then also palindrome)
                    dp[l][r] = true;
                    if ((r - l + 1) > maxLen) {
                        start = l;
                        maxLen = r - l + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}