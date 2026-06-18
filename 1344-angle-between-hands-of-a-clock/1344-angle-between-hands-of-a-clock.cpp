class Solution {
public:
    double angleClock(int hour, int minutes) {
        double hr1 = 30;// 1 hour -> 30 deg
        double min1 = 6; // 1 min -> 6 deg
        double aff = 0.5;// min hands affects hour hands by 0.5 deg extra

        double ang1 = (hour % 12)* hr1 + (minutes * aff);
        double ang2 = minutes * min1;

        double ans = ang1 > ang2 ? ang1 - ang2 : ang2 - ang1;
        return 360.0 - ans > ans ? ans: 360.0 - ans; 
    }
};