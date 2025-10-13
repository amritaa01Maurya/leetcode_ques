class Solution {
    public boolean isAnagrams(String s, String t) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<n;i++){
            if(!isAnagrams(words[i], ans.get(ans.size()-1))){
                ans.add(words[i]);
            }
        }
        return ans;
    }
}