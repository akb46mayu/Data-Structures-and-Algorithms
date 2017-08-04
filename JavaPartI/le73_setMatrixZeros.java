Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

public class Solution {  // S = O(m + n)
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] rowtag = new int[m];
        int[] coltag = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowtag[i] = 1;
                    coltag[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowtag[i] == 1 || coltag[j] == 1) {
                    matrix[i][j] = 0;
                }
            } 
        }
    }
}
