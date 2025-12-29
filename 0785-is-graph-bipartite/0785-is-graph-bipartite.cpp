class Solution {
public:
    bool dfs(vector<vector<int>>& graph, int curr, vector<int>& col) {
        for(int neigh:graph[curr]){
            if(col[neigh] == -1){
                col[neigh] = col[curr] == 0? 1:0;
                if(!dfs(graph, neigh, col)){
                    return false;
                }
            }else if(col[neigh] == col[curr]){
                return false;
            }
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> col(n, -1);
        for(int i=0;i<n;i++){
            if(col[i] == -1){
                col[i] = 0;
                if(!dfs(graph, i, col)){
                    return false;
                }
            }
        }
        return true;
    }
};