class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (k >= n / 2) {
            return quickProf(prices);
        }
        int[][] glbmax = new int[n][k + 1];
        for (int j = 1; j <= k; j++) { // i: days
            int locmax = -prices[0]; // local max buy uptill now.
            for (int i = 1; i < n; i++) {  // j: trans idx
                glbmax[i][j] = Math.max(glbmax[i - 1][j] , locmax + prices[i]);
                locmax = Math.max(locmax, glbmax[i][j - 1] - prices[i]);
            }
        }
        return glbmax[n - 1][k];
    }
    
    private int quickProf(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
