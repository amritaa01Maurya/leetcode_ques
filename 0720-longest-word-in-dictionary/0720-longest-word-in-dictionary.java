class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String ans = "";
        Set<String> set = new HashSet<>();
        for(String s: words){
            if(s.length() == 1 || set.contains(s.substring(0, s.length()-1))){
                set.add(s);
                if(s.length() > ans.length()){
                    ans = s;
                }
            }
        }
        return ans;
    }
}