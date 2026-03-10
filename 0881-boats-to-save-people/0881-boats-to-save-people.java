class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 1;
        int curr = 0;
        for(int p:people){
            if(curr + p <= limit){
                curr += p;
            }else{
                curr = p;
                boat++;
            }
        }
        return boat;
    }
}