class NumArray {
    int[] st;
    int n;
    int[] arr;

    public void build(int i, int si, int sj){
        if(si == sj){
            st[i] = arr[si];
            return;
        }
        int mid = si + (sj - si)/2;
        build(2*i+1, si, mid);
        build(2*i+2, mid+1, sj);

        st[i] = st[2*i+1] + st[2*i+2];

    }
    public void update(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }
        st[i] += diff;
        int mid = si + (sj - si)/2;
        if(si != sj){
            update(2*i+1, si, mid, idx, diff);
            update(2*i+2, mid+1, sj, idx, diff);
        }
    }
    
    public int sum(int i, int si, int sj, int l, int r){
        if(sj < l || si > r){
            return 0;
        }else if(si >= l && sj <= r){
            return st[i];
        }
        int mid = si + (sj - si)/2;
        int left = sum(2*i+1, si, mid, l, r);
        int right = sum(2*i+2, mid+1, sj, l, r);
        
        return left + right;
    }


    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        st= new int[4*n];
        build(0, 0, n-1);
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;

        update(0, 0, n -1, index, diff);
    }
    
    public int sumRange(int left, int right) {
        return sum(0, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */