class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        m1.put(-1,0);
        m2.put(-1,0);
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                m1.put(nums[i], m1.getOrDefault(nums[i],0)+1);
            }else{
                m2.put(nums[i],m2.getOrDefault(nums[i],0)+1);
            }
        }

        int maxOdd = -1;
        int smaxOdd = -1;
        for(int key:m2.keySet()){
            if(m2.get(key) > m2.get(maxOdd)){
                smaxOdd = maxOdd;
                maxOdd = key;
            }else if(m2.get(key) > m2.get(smaxOdd)){
                smaxOdd = key;
            }
        }
        int maxEven = -1;
        int smaxEven = -1;
        for(int key:m1.keySet()){
            if(m1.get(key) > m1.get(maxEven)){
                smaxEven = maxEven;
                maxEven = key;
            }else if(m1.get(key) > m1.get(smaxEven)){
                smaxEven = key;
            }
        }

        int minrem = 0;
        if(maxOdd != maxEven){
            minrem = n - (m1.get(maxEven) + m2.get(maxOdd));
        }else {    

            minrem = n - Math.max(m2.get(maxOdd) + m1.get(smaxEven), m1.get(maxEven) + m2.get(smaxOdd));
        }
        return minrem;
    }
}