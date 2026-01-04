class Solution {
    public boolean canValid(String seq, String w, int k) {
        StringBuilder sb = new StringBuilder();
        sb.repeat(w,k);
        if(seq.contains(sb.toString())){
            return true;
        }
        return false;
    }
    public int maxRepeating(String sequence, String word) {
        int  n = sequence.length();
        int  m = word.length();
        int l = 1;
        int h = 100;
        int maxK =0;
        
        while(l <= h){
            int mid = (l + h)/2;
            if(canValid(sequence, word, mid)){
                l = mid + 1;
                maxK = mid;
            }else{
                h = mid - 1;
            }
        }

        return maxK;
    }
}