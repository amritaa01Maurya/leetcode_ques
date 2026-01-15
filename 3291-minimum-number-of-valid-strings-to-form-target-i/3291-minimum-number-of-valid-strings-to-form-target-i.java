class Solution {
    class Node{
        Node[] child = new Node[26];

        public Node(){
            for(int i=0;i<26;i++){
                child[i] = null;
            }
        }
    }

    private Node root = new Node();

    private void insert(String s){
        Node curr = root;
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i) - 'a';
            if(curr.child[val] == null){
                curr.child[val] = new Node();
            }

            curr = curr.child[val];
        }
    }
    public int minValidStrings(String[] words, String target) {
        for(String s:words){
            insert(s);
        }
      
        int n = target.length();
        int[] dp = new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0;i<n;i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            Node curr = root;
            for(int j=i;j<n;j++){
                int idx = target.charAt(j)-'a';
                if(curr.child[idx]== null){
                    break;
                }
                curr = curr.child[idx];

                dp[j+1] = Math.min(dp[j+1],dp[i]+1);
            }
        }
        return dp[n]== Integer.MAX_VALUE? -1 :dp[n];
    }
}