class Solution {
    public String largestEven(String s) {
        if(s.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        while(!sb.isEmpty() && sb.charAt(sb.length()-1) == '1'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}