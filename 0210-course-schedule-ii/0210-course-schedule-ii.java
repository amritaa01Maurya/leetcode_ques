class Solution {
    public int[] solve(List<List<Integer>> adj, int[] indeg, int n) {
        int[] topoSort = new int[n];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            topoSort[idx++] = curr;
            for(int neigh:adj.get(curr)){
                indeg[neigh]--;
                if(indeg[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        return idx == n? topoSort: new int[0];
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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