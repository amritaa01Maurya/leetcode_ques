class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        int prevEnd = intervals[0][1];
        int count = 0;
        for(int i=1;i<n;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(prevEnd > currStart){
                if(prevEnd > currEnd){
                    prevEnd = currEnd;
                }
                count++;
            }else{
                prevEnd = currEnd;
            }
        }
        return count;
    }
}