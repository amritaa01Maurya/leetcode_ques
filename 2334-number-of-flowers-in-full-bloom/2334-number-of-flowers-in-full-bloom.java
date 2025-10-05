class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] count = new int[people.length];
        for(int i=0;i<people.length;i++){
            int time = people[i];
            int l =0;
            int r = n - 1;
            while(l <= r){
                int mid = l + ( r - l)/2;
                if(start[mid] <= time){
                    l = mid + 1;
                }else{
                    r = mid- 1;
                }
            }
            int bloom = l;

            l =0;
            r = n - 1;
            while(l <= r){
                int mid = l + ( r - l)/2;
                if(end[mid] < time){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            int unbloom = l;
            count[i] = bloom - unbloom;
        }
        return count;
    }
}