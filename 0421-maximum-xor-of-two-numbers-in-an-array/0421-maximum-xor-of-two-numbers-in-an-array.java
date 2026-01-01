class Trie{
    public class Node{
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
    public int getMaxXor(int num){
        Node curr = root;
        int maxXor = 0;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1;
            int opp = 1 - bit;
            if(curr.child[opp] != null){
                maxXor |= (1 << i);
                curr = curr.child[opp];
            }else{
                curr = curr.child[bit];
            }
            
        }
        return maxXor;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int n = nums.length;
        int xor =  0;

        for(int num: nums){
            trie.insert(num);
        }

        for(int num: nums){
            xor = Math.max(xor, trie.getMaxXor(num));
        }
        return xor;
    }
}