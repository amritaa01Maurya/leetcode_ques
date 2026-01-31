class Solution {
    public char nextGreatestLetter(char[] l, char t) {
        int i=0;
        int j=l.length-1;
        char ch=l[0];
        while(i<=j){
            int mid=i+(j-i)/2;
            if(l[mid]>t){
                ch=l[mid];
                j=mid-1;
            }else{
                i=mid+1;
            }
        }return ch;
    }
}