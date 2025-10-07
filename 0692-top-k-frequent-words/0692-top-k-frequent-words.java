class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String num: words){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<String> l = new ArrayList<>(map.keySet());
        l.sort(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(map.get(a) == map.get(b)){
                    return a.compareTo(b);
                }
                return Integer.compare(map.get(b), map.get(a));
            }
        });

        List<String> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(l.get(i));
        }
        return ans;
    }
}