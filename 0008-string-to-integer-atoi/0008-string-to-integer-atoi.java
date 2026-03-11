class Solution {
    public int myAtoi(String ns) {
        String s = ns.trim();
        if(s.length() == 0){
            return 0;
        }
        boolean pos = true;
        int i=0;
        if(s.charAt(i) == '-'){
            pos = false;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }else if(s.charAt(i) < '0' || s.charAt(i) > '9'){
            return 0;
        }

        long num  = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int val = s.charAt(i) - '0';
            num = num * 10 + val;

            if(pos && num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(!pos && -num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return pos ?(int)num : (int)-num;
    }
}