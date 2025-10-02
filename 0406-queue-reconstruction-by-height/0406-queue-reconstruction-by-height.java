class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n =people.length;
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(a[1], b[1]);

            }
        });
        List<int[]> ll = new ArrayList<>();
        for(int[] arr: people){
            int pos = arr[1];
            ll.add(pos, arr);
        }
        return ll.toArray(new int[n][]);
    }
}