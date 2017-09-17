class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0;
        int F0 = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            F0 += i * A[i];
        }
        int max = F0;
        for (int k = 1; k < n; k++) {
            
            F0 += sum - n * A[n - k];
            max = Math.max(F0, max);
        }
        return max;
    }
}
