class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        vector<vector<pair<int, double>>> adj(n);
        for(int i =0;i<edges.size();i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj[u].push_back({v, prob});
            adj[v].push_back({u, prob});
        }
        vector<double> maxProb(n, 0.0);

        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start_node});
        maxProb[start_node] = 1.0;

        while (!pq.empty()) {
            auto curr = pq.top();
            pq.pop();
            double prob = curr.first;
            int curr_node = curr.second;
            if(curr_node == end_node){
                return maxProb[curr_node];
            }
            for (auto &e:adj[curr_node]) {
                int neigh = e.first;
                double nProb = e.second;
                if(prob * nProb > maxProb[neigh]){
                    maxProb[neigh] = prob * nProb;
                    pq.push({maxProb[neigh], neigh});
                }
            }
        }
        return 0.0;
    }
};