class Solution {
    int len = 0;
    public boolean isUnique(String path) {
        char[] arr = path.toCharArray();
        if (arr != null) Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public void length(List<String> arr, String path, int i) {
        if(isUnique(path)){
            len = Math.max(len, path.length());

        }
        if(i >= arr.size() || !isUnique(path)){
            return;
        }
        for(int j=i;j<arr.size();j++){
            length(arr, path + arr.get(j), j + 1);
        }
    }
    public int maxLength(List<String> arr) {
        length(arr, "", 0);
        return len;
    }
}