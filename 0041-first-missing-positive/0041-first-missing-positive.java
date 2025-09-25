class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> l = new TreeSet<>();
        for(int num:nums){
            if(num > 0){
                l.add(num);
            }
        }
        int missingNo = 1;
        for(int num: l){
            if(num == missingNo){
                missingNo++;
            }else if (num > missingNo){
                return missingNo;
            }
        }
        return missingNo;
    }
}