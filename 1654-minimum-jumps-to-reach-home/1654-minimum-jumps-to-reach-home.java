class Solution {
    class Pair{
        int pos, step;
        char prev;

        Pair(int p, char ch, int s){
            this.pos = p;
            this.prev = ch;
            this.step = s;
        }
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Set<Integer> set = new HashSet<>();
        int maxFB = 0;
        for(int f:forbidden){
            set.add(f);
            maxFB = Math.max(f, maxFB);
        }
        
        int limit = 6000;
        boolean[][] vis = new boolean[limit+1][2];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, '#', 0)); // pos, prev, step

        vis[0][0] =true;
        vis[0][1]=true;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int nd = p.pos;
            char prvMove = p.prev;
            int st = p.step;

            if(nd == x){
                return st;
            }
            
            int back = 0;
            if(prvMove != 'b' && nd - b >= 0){
                back = nd - b;
                String key = back+","+"b";
                if(!set.contains(back) && !vis[back][1]){
                    vis[back][1] = true;;
                    q.add(new Pair(back, 'b', st + 1));
                }
            }
            int forw = nd + a;
            if(forw < limit && !set.contains(forw) &&  !vis[forw][0]){
                vis[forw][0]=true;;
                q.add(new Pair(forw, 'a', st + 1));
            }
        }
        return -1;
    }
}