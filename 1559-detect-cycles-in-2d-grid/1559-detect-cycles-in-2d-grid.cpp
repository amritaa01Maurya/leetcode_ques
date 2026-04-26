class Solution {
public:
    int dir[5] = {-1, 0, 1, 0, -1};
    int n, m;
    bool solve(int i, int j, vector<vector<char>>& grid, int pari, int parj, int step, vector<vector<bool>>& vis) {
        if(i >= n || j >= m){
            return false;
        }

        if(vis[i][j]){
            return step >= 4;
        }

        vis[i][j] = true;

        for(int d=0;d<4;d++){
            int ni = i + dir[d];
            int nj = j + dir[d+1];

            if(ni < 0 || nj < 0 || ni >= n || nj >= m || (ni == pari && nj == parj) || grid[ni][nj] != grid[i][j]){
                continue;
            }
            if(solve(ni, nj, grid, i, j, step + 1, vis)){
                return true;
            }

        }
        return false;
    }

    bool containsCycle(vector<vector<char>>& grid) {
        n = grid.size();
        m = grid[0].size();
        vector<vector<bool>> vis(n,vector<bool>(m, false));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(i, j, grid, -1, -1, 0, vis)){
                    return true;
                }
            }
        }
        return false;
    }
};