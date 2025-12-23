class Solution {
    public boolean closeStrings(String w1, String w2) {
        if(w1.length() != w2.length()){
            return false;
        }
        Set<Character> set = new HashSet<>();
        int[] freq1= new int[26];
        for(char ch:w1.toCharArray()){
            set.add(ch);
            freq1[ch - 'a']++;
        }
        int[] freq2= new int[26];
        for(char ch:w2.toCharArray()){
            freq2[ch - 'a']++;
        }
        for(char ch:w2.toCharArray()){
            if(!set.contains(ch)){
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}