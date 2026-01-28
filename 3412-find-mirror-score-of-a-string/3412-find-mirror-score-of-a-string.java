class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        Stack<Integer>[] arr = new Stack[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Stack<>();
        }

        long score = 0;
        for(int i=0;i<n;i++){
            int ch = s.charAt(i) - 'a';
            if(!arr[25 - ch].isEmpty()){// check in stack of the mirror of the char
                score += (i - arr[25 - ch].pop()); // if present take j from it (i - j)
            }else{
                arr[ch].push(i);// push the char idx in original stack 
            }
        }
        return score;
    }
}