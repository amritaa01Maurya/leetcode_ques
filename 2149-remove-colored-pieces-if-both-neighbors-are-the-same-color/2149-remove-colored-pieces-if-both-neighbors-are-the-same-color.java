class Solution {
    public boolean winnerOfGame(String s) {
        int n = s.length();
        if(n <= 2){
            return false;
        }
        int count_A = 0;
        int count_B = 0;
        int A = 0;
        int B = 0;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i) == 'A' && s.charAt(i-1) == 'A' && s.charAt(i+1) == 'A'){
                count_A++;
            }else if(s.charAt(i) == 'B' && s.charAt(i-1) == 'B' && s.charAt(i+1) == 'B'){
                count_B++;
            }
        }
        if(count_A <= count_B){
            return false;
        }
        return true;
    }
}