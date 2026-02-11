class Solution {
    public String maxValue(String s, int x) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        // place x such that num becomes minimum
        if(sb.charAt(0) == '-'){
            // start from right
            boolean placed = false;
            for(int i =1;i<n;i++){
                if((sb.charAt(i) - '0') > x && !placed){
                    sb.insert(i, x);
                    placed = true;
                    break;
                }
            }
            if(!placed){
                sb.append(x);
            }
        }else{
            boolean placed = false;
            for(int i =0;i < n;i++){
                if((sb.charAt(i) - '0') < x && !placed){
                    sb.insert(i, x);
                    placed = true;
                    break;
                }
            }
            if(!placed){
                sb.append(x);
            }
        }
        return sb.toString();
    }
}