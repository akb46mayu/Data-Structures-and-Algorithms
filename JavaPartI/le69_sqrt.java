class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int i = 1, j = x / 2;
        
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (mid <= x / mid) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        if ( j  <= x / j) {
            return j;
        } 
        return i;
    }
}
