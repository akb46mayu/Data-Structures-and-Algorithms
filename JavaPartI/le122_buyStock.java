

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int res = 0;
        
        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
