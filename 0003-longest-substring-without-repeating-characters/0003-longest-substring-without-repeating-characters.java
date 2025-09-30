class Solution {
    public int lengthOfLongestSubstring(String st) {
        int l = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int r = 0; r < st.length(); r++) {
            while (set.contains(st.charAt(r))) {
                set.remove(st.charAt(l));
                l++;
            }
            set.add(st.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}