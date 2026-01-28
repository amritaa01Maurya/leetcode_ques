class Solution {
    public int getIdx(List<Integer> list, int n){
        int l = 0;
        int r = list.size();
        while(l < r){
            int mid = (l + r)/2;
            if(list.get(mid) < n){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //make height to width list map
        for(int[] rect:rectangles){
            map.computeIfAbsent(rect[1], k -> new ArrayList<>()).add(rect[0]);
        }
        // sort the width list
        for(int key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] ans = new int[points.length];
        int j = 0;
        for(int[] p:points){
            int h = p[1];
            int count = 0;
            // search in h to 100 if points exists
            for(int i=h;i<=100;i++){
                if(map.containsKey(i)){
                    int idx = getIdx(map.get(i), p[0]);// find the idx
                    count += (map.get(i).size() - idx);
                }
            }
            ans[j++] = count;
        }
        return ans;
    }
}