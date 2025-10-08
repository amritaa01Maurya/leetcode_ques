class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        if(n <= 2){
            return false;
        }
        int count_A = 0;
        int count_B = 0;
        int A = 0;
        int B = 0;
        for(int i=0;i<n;i++){
            if(colors.charAt(i) == 'A'){
                if(count_B >= 3) B += count_B-2; 
                count_A++;
                count_B = 0;
            }else{
                if(count_A >= 3) A += count_A - 2;
                count_B++;
                count_A = 0;
            }
        }
        if(count_B >= 3) B += count_B-2;
        if(count_A >= 3) A += count_A - 2;
        if(A <= B){
            return false;
        }
        return true;
    }
}