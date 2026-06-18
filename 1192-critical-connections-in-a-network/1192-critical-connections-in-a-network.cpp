class Solution {
public:
    vector<vector<int>> ans;
    vector<int> dt;
    vector<int> low;
    int time = 0;
    void solve(int u, vector<int>& vis, int par,
               vector<vector<int>>& adj) {
        vis[u] = 1;
        dt[u] = low[u] = ++time;
        for (int v : adj[u]){
            if (!vis[v]) {
                solve(v, vis, u, adj);

                low[u] = min(low[u], low[v]);
                if (low[v] > dt[u]) {
                    ans.push_back({u, v});
                }
            }else if(v != par) {
                low[u] = min(low[u], dt[v]);
            }
        }
    }

    vector<vector<int>> criticalConnections(
        int n,
        vector<vector<int>>& connections) {

        vector<vector<int>> adj(n);
        for (auto &c : connections) {
            adj[c[0]].push_back(c[1]);
            adj[c[1]].push_back(c[0]);
        }
        vector<int> vis(n, 0);
        dt.resize(n);
        low.resize(n);
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                solve(i, vis, -1, adj);
            }
        }
        return ans;
    }
};