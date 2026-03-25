class RangeFreqQuery {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int lowerbound(List<Integer> list, int idx) {
        int ans = list.size();
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(list.get(mid) >= idx){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int upperbound(List<Integer> list, int idx) {
        int ans = list.size();
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(list.get(mid) > idx){
                ans = mid;
                r = mid - 1;// go to left to find 1st idx greater than req
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)){
            return 0;
        }
        List<Integer> list = map.get(value);

        int lb = lowerbound(list, left);// 1st idx greater than equal to left
        int ub = upperbound(list, right);// 1st idx greater than right
        return ub - lb;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */