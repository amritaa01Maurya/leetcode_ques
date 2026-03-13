class NumArray {
    int[] bit;
    int n;
    int[] nums;
    public NumArray(int[] nums2) {
        nums = nums2;
        n = nums2.length;
        bit = new int[n+1];
        for(int i=0;i<n;i++){
            update2(i+1, nums[i]);
        }
    }

    private void update2(int id, int val){
        while(id <= n){
            bit[id] += val;
            id += (id & -id);
        }
    }

    private int query(int id){
        int ans = 0;
        while(id > 0){
            ans += bit[id];
            id -= (id & -id);// -1 last bit
        }
        return ans;
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        update2(index+1, diff);
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */