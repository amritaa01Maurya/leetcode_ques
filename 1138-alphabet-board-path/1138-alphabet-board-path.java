class Solution {
    public String alphabetBoardPath(String target) {
        HashMap<Character, int[]> map = new HashMap<>();
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        for(int i=0;i<6;i++){
            String s = board[i];
            for(int j=0;j<s.length();j++){
                map.put(s.charAt(j), new int[]{i, j});
            }
        }
        int r = 0;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch: target.toCharArray()){
            int x = map.get(ch)[0];
            int y = map.get(ch)[1];
            while(c > y){
                sb.append('L');
                c--;
            }
            while(r < x){
                sb.append('D');
                r++;
            }
            while(r > x){
                sb.append('U');
                r--;
            }
            while(c < y){
                sb.append('R');
                c++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}