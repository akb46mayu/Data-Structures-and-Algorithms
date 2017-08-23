class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] L = new int[n], R = new int[n], H = new int[n];
        Arrays.fill(R, n);
        int res = 0;
        for (int i = 0; i < m; i++) {
            int curl = 0, curr = n;
            for (int j = 0; j < n; j++) {
                //R[j] = n;
                if (matrix[i][j] == '1') {
                    L[j] = Math.max(curl, L[j]);
                    H[j]++;
                } else {
                    L[j] = 0;
                    curl = j + 1; 
                    H[j] = 0;
                }
            }
            //
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(curr, R[j]);
                } else {
                    R[j] = n;
                    curr = j; 
                }
                res = Math.max(res, (R[j] - L[j]) * H[j]);
               
            }
        }
        return res;
    }
}
