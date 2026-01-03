class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];

        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            indeg[v]++;
        }
        int count = 0;
        int node = -1;
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                count++;
                node = i;
            }
        }
        return count > 1 ? -1 : node;
    }
}