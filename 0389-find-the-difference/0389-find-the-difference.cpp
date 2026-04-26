class Solution {
public:
    char findTheDifference(string s, string t) {
        int sum = 0;
        for(char ch : t){
            sum += (int)ch;
        }

        for(char ch : s){
            sum -= (int)ch;
        }
        return (char)sum;
    }
};