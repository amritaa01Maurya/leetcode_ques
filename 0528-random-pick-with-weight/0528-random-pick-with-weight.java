class Solution {
    Random rand = new Random();
    int[] cumWt;
    int n;
    public Solution(int[] w) {
        n = w.length;
        cumWt = new int[n];
        cumWt[0] = w[0];
        for(int i=1;i<n;i++){
            cumWt[i] = cumWt[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        int num = rand.nextInt(cumWt[n-1] - 1 + 1) + 1;
        
        for(int i=0;i<n;i++){
            if(cumWt[i] >= num){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */