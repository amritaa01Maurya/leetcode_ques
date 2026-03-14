class Solution {
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }

        int temp = 0;
        while(num > 0){
            int r = num % 10;
            temp += r;
            num /= 10;
        }

        return addDigits(temp);
    }
}