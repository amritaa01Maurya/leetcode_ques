class Solution {
    class Node{
        Node[] child = new Node[2];

        Node(){
            for(int i=0;i<2;i++){
                child[i] = null;
            }
        }
    }

    private Node root = new Node();

    public void insert(int num){
        Node curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            if(curr.child[bit] == null){
                curr.child[bit] = new Node();
            }
            curr = curr.child[bit];
        }
    }

    public int maxXor(int num){
        Node curr = root;

        int mask = 0;
        for(int i=31;i>=0;i--){
            int bit = ((num >> i) & 1);
            int opp = 1 - bit;
            if(curr.child[opp] != null){
                mask |= (1 << i);// if opposite bit exist then nums ith bit and its ith bit = 1
                curr = curr.child[opp];
            }else{// if not exist, then xor will be 0
                curr = curr.child[bit];
            }
        }
        return mask;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[][] arr = new int[m][3];

        for(int i=0;i<m;i++){
            arr[i][0] = i;// idx
            arr[i][1] = queries[i][0];//  xi
            arr[i][2] = queries[i][1];// mi
        }

        Arrays.sort(nums);
        Arrays.sort(arr, (a,b) -> a[2] - b[2]);//sort on the basis of mi
        int[] ans = new int[m];

        int j=0;
        for(int i=0;i<m;i++){
            while(j < n && nums[j] <= arr[i][2]){
                insert(nums[j]);
                j++;
            }
            if(j == 0){
                ans[arr[i][0]] = -1;
            }else{
                // now find num such that xor of it and xi is max
                ans[arr[i][0]] = maxXor(arr[i][1]);
            }
        }
        return ans;
    }
}