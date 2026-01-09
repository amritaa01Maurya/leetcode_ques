class Solution {
    public int hamming(String s1, String s2) {
        int d = 0;
        for(int i = 0;i<s1.length();++i){
            if(s1.charAt(i) != s2.charAt(i)){
                d++;   
            }  
        }
        return d;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp =new int[n];
        Arrays.fill(dp, 1);
        int[] path = new int[n];
        Arrays.fill(path, -1);

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(words[i].length() == words[j].length() && hamming(words[i], words[j]) == 1 && groups[i] != groups[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                }
            }
        }
        int maxLen = 0;
        int endIdx = -1;
        for(int i=0;i<n;i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                endIdx = i;
            }
        }

        List<String> ans = new ArrayList<>();
        while(endIdx != -1){
            ans.add(0, words[endIdx]);
            endIdx = path[endIdx];
        }
        return ans;
    }
}