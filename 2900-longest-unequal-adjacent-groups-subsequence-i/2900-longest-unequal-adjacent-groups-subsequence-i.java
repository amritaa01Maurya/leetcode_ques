class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       int n = words.length;
       List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int prev = 0;
       for(int i =1;i<n;i++){
            if(groups[prev] != groups[i]){
                ans.add(words[i]);
                prev = i;
            }
       }
       return ans;
    }
}