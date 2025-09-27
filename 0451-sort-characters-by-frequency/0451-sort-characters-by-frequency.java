class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map =new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        List<Character> l = new ArrayList<>(map.keySet());
        l.sort((a,b)-> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char ch: l){
            int count = map.get(ch);
            while(count-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}