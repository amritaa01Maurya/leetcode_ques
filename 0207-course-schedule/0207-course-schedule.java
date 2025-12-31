class Solution {
    public boolean solve(List<List<Integer>> adj, int[] indeg, int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            for(int neigh:adj.get(curr)){
                indeg[neigh]--;
                if(indeg[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        return count == n ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
        }
        int[] indeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neigh:adj.get(i)){
                indeg[neigh]++;
            }
        }
        return solve(adj, indeg, numCourses);
    }
}