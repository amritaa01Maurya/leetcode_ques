class Solution {
    class Pair{
        String str;
        int step;

        Pair(String st, int s){
            this.str = st;
            this.step = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.remove();
            String st = p.str;
            int stp = p.step;
            if(st.equals(endWord)){
                return stp;
            }
            for(int i=0;i<st.length();i++){
                char[] a = st.toCharArray();
                for(char c='a';c<='z';c += 1){
                    a[i]=c;
                    String ns = new String(a);
                    if(set.contains(ns)){
                        set.remove(ns);
                        q.add(new Pair(ns, stp+1));
                    }
                }
            }
        }
        return 0;
    }
}