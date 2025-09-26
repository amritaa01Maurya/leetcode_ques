class Solution {
    public int findMinArrowShots(int[][] points) {
        int n =points.length;
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1], b[1]);
            }
        });
        int prevEnd = points[0][1];
        int minArrow = 0;
        for(int i=1;i<n;i++){
            int currStart = points[i][0];
            if(currStart <= prevEnd){
                continue;
            }else{
                prevEnd = points[i][1];
                minArrow++;
            }
        }
        return minArrow + 1;
    }
}