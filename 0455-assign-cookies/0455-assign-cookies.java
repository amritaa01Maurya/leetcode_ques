class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i  = 0;
        int count = 0;
        for(int j = 0; j < m && i < n; j++){
            if(s[j] >= g[i]){
                count++;
                i++;
            }
        }
        return count;
    }
}