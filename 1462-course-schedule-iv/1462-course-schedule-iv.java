class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        
        boolean[][] canReach = new boolean[n][n];

        for(int[] pre:prerequisites){
            int u= pre[0];
            int v= pre[1];
            canReach[u][v] = true;
        }

        // check if i can be reach to j through k
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    canReach[i][j] |= canReach[i][k] && canReach[k][j];
                }
            }
        }

        int m = queries.length;

        List<Boolean> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            ans.add(canReach[u][v]);
        }

        return ans;
    }
}