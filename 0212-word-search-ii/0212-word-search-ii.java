class Solution {
    int[] dirs = {-1, 0, 1, 0, -1};
    class Node{
        Node[] child = new Node[26];
        String end;

        Node(){
            for(int i=0;i<26;i++){
                child[i]= null;
            }
        }
    }

    private Node root = new Node();

    public void insert(String s){
        Node curr = root;
        for(char ch:s.toCharArray()){
            if(curr.child[ch-'a'] == null){
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.end = s;
    }

    public void search(char[][] board, int i, int j, Node curr, List<String> l){
        int n = board.length;
        int m = board[0].length;

        if(i < 0 || j >= m || j < 0 || i >= n || board[i][j] == '#'){
            return;
        }
        char ch = board[i][j];

        if (curr.child[ch - 'a'] == null) return;

        curr = curr.child[ch - 'a'];

        if(curr.end != null){// if there is word ending here
            l.add(curr.end);
            curr.end = null;// same word can not be used for another word
        }

        board[i][j] = '#';
        for(int d=0;d<4;d++){
            search(board, i+dirs[d], j + dirs[d+1], curr, l);
        }
        board[i][j] = ch;
        
    }
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        //insert word in trie
        for(String w:words){
            insert(w);
        }

        List<String> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, l);
                }
            }
        }
        return l;
    }
}