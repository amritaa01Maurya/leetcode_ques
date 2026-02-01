class Solution {
    public int[] findOriginalArray(int[] changed) {
        int  n = changed.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        if(n % 2 != 0){
            return new int[0];
        }
        for(int num:changed){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(changed);
        int[] ans = new int[n/2];
        int idx = 0;
        for(int num:changed){
            if(num == 0){// if zero,  even count of zero or not
                if(map.get(num) >= 2){//
                    map.put(num, map.get(num) - 2);
                    ans[idx++] = num;
                }
            }else if(map.containsKey(num) && map.containsKey(2*num)){// other than 0, check if num and its double exists
                ans[idx++] = num;
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }

                map.put(2 * num, map.get(2 * num) - 1);
                if(map.get(2 * num) == 0){
                    map.remove(2 * num);
                }
            }
        }
        return idx == n/2 ? ans : new int[0];
    }
}