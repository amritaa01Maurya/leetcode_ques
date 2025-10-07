class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int ar = a[0] * a[0] + a[1] * a[1];
                int br = b[1] * b[1] + b[0] * b[0];
                return Integer.compare(ar, br);
            }
        });
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
}