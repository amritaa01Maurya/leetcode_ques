class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] map = new long[n];
        
        long maxscore = 0;
        int maxnode = -1;
        for(int i=0;i<n;i++){
            map[edges[i]] += i;
        }

        for(int i=0;i<n;i++){
            if(map[i] > maxscore){
                maxscore = map[i];
                maxnode = i;
            }
        }
        return maxnode;
    }
}