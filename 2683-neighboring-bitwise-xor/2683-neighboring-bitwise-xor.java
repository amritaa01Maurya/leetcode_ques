class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int d:derived){//here original arrays each ele is used twice to make drived array so total xor sum will be 0
            xor ^= d;
        }

        return xor == 0;
    }
}