class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l =0;
        int count = 0;
        int maxFruits = 0;
        for(int i=0;i<n;i++){
            map.put(fruits[i], map.getOrDefault(fruits[i],0)+1);
            count++;
            while(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                count--;
                l++;
            }
            maxFruits = Math.max(maxFruits, count);
        }
        return maxFruits;
    }
}