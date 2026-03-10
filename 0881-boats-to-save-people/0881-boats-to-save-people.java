class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;
        int s = 0;
        int e = people.length - 1;
        while(s <= e){
            if(people[s] + people[e] <= limit){// if min & max wt people can fit under one boat
                s++;
                e--;
            }else{// if max will not fit with min then it will take one boat space for itself
                e--;
            }
            boat++;
        }
        return boat;
    }
}