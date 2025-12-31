class Node{
    Node[] child = new Node[26];
    boolean end = false;

    public Node(){
        for(int i=0;i<26;i++){
            child[i] = null;
        }
    }
}
class Trie {
    Node root;
    public Trie() {
       root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(curr.child[ch - 'a'] == null){
                return false;
            }
            curr = curr.child[ch - 'a'];
        }
        return curr.end == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch: prefix.toCharArray()){
            if(curr.child[ch - 'a'] == null){
                return false;
            }
            curr = curr.child[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */