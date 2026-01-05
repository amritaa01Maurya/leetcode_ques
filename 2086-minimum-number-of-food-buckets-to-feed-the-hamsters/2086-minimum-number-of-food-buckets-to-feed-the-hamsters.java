class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();

        boolean[] placed = new boolean[n];
        for(int i=0;i<n;i++){
            if(hamsters.charAt(i) == 'H'){
                boolean left = i > 0 ? hamsters.charAt(i-1) == '.': false;
                boolean right = i < n -1 ? hamsters.charAt(i+1) == '.': false;
                if(!left && !right){
                    return -1;
                }
                else if((i == 0 || !placed[i-1]) && right){
                    placed[i+1]=true;
                }else if(!right){
                    placed[i-1] = true;
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(placed[i]){
                count++;
            }
        }
        return count;
    }
}