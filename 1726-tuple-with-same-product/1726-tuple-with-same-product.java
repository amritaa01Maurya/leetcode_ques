class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prod = nums[i]*nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        int count = 0;
        for(int key:map.keySet()){
            if(map.get(key) > 1){
                int m = map.get(key);
                count += m * (m - 1) * 4;
            }
        }
        return count;
    }
}