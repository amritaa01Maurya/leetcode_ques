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
        HashMap<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int maxFB = 0;
        for(int f:forbidden){
            set.add(f);
            maxFB = Math.max(f, maxFB);
        }
        map.put(0+","+"#", 0);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, '#', 0)); // pos, prev, step

        int limit = 6000;

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
                if(!set.contains(back) && map.getOrDefault(key, Integer.MAX_VALUE) > st + 1){
                    map.put(key, st + 1);
                    q.add(new Pair(back, 'b', st + 1));
                }
            }
            int forw = nd + a;
            String k = forw + "," + "a";
            if(forw < limit && !set.contains(forw) && map.getOrDefault(k, Integer.MAX_VALUE) > st + 1){
                map.put(k, st + 1);
                q.add(new Pair(forw, 'a', st + 1));
            }
        }
        return -1;
    }
}