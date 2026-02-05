class Solution {
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
        curr.end = s;// at last store the root word at curr.end
    }

    public String getRoot(String s){
        Node curr = root;
        for(char ch:s.toCharArray()){
            if(curr.child[ch-'a'] != null){// if curr char exist
                curr = curr.child[ch-'a'];
                if(curr.end != null){// if it is end of word
                    return curr.end;// return the root word
                }
            }else{// if curr char not exist return original word
                return s;
            }
        }
        return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();

        String[] sent = sentence.split(" ");

        for(String s:dictionary){
            insert(s);
        }

        for(String s:sent){
            String st = getRoot(s);
            ans.append(st).append(" ");
        }
        return ans.toString().trim();
    }
}