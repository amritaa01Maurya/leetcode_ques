class Solution {
    public boolean isAnagram(int[] arr){
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int len = p.length();
        int m = s.length();
        int[] freq = new int[26];
        for(int i=0;i<len;i++){
            freq[p.charAt(i)-'a']++;
        }
        int l =0;
        for(int r=0;r<m;r++){
            freq[s.charAt(r)-'a']--;
            while(r-l+1 > len){
                freq[s.charAt(l)-'a']++;
                l++;
            }
            if(isAnagram(freq)){
                indices.add(l);
            }  
        }
        return indices;
    }
}