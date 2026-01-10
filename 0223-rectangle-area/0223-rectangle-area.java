class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int lenA = ax2 - ax1;
        int widA = ay2 - ay1;
        int lenB = bx2 - bx1;
        int widB = by2 - by1;
        int areaA = lenA * widA;
        int areaB = lenB * widB;

        int totArea = areaA + areaB;
        int lenOverlap = Math.max(0,Math.min(bx2, ax2) - Math.max(bx1, ax1));
        int widOverlap = Math.max(0, Math.min(by2, ay2) - Math.max(by1, ay1));

        int overLapArea = lenOverlap * widOverlap;
        totArea -= overLapArea;

        return totArea;
    }
}