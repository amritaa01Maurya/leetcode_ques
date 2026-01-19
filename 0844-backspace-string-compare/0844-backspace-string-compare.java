class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!sb.isEmpty() && s.charAt(i) == '#'){
                sb.deleteCharAt(sb.length()-1);
            }
            if(s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            if(!st.isEmpty() && t.charAt(i) == '#'){
                st.deleteCharAt(st.length()-1);
            }
            if(t.charAt(i) != '#'){
                st.append(t.charAt(i));
            }
        }
        return sb.toString().equals(st.toString());
    }
}