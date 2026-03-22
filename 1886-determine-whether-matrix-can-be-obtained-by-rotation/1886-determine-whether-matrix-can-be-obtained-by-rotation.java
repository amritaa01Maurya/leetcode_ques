class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int[][] trans = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                trans[j][i] = mat[i][j];
            }
        }
        for(int i=0;i<n;i++){
            int l = 0;
            int r = n - 1;
            while(l <= r){
                int temp = trans[i][l];
                trans[i][l] = trans[i][r];
                trans[i][r] = temp;
                l++;
                r--;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = trans[i][j];
            }
        }

    }
    public boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(mat[i][j] != target[i][j]){
                    return false;
               }
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(isEqual(mat, target)){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
}