class Solution {
    public void swapChars(Map<Character, Integer> map, char i, char j){
        map.put(j, map.getOrDefault(j,0)+1);//put j in the map
        
        map.put(i, map.get(i) - 1);//sub -1 from freq
        if(map.get(i) == 0){//if freq 0 remove i from map
            map.remove(i);
        }
    }
    public boolean isItPossible(String w1, String w2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c:w1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(char c:w2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for(char i='a';i <= 'z';i += 1){
            for(char j='a';j <= 'z';j += 1){
                if(map1.containsKey(i) && map2.containsKey(j)){
                    //swap i & j
                    // put j in w1 and remove i from it
                    swapChars(map1, i, j);

                    // put i in w2 and remove j from it
                    swapChars(map2, j, i);
                    
                    //check it there are same chars
                    if(map1.size() == map2.size()){
                        return true;
                    }

                    //if not then reset the changes
                    swapChars(map1, j, i);

                    swapChars(map2, i, j);

                }
            }
        }
        return false;
    }
}