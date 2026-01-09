class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length;
        int maxLen = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);

        for(int i=1;i<n;i++){
            if(map.containsKey(arr[i] - diff)){
                map.put(arr[i], map.get(arr[i] - diff) + 1);
            }else{
                map.put(arr[i], 1);
            }
            maxLen = Math.max(maxLen, map.get(arr[i]));
        }
        return maxLen;
    }
}