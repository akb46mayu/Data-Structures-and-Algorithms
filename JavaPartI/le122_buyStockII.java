

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

////////
class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] min = new int[n];
        int res = 0;
        min[0] = prices[0];
        for (int i = 1; i < n; i++) {
           min[i] = Math.min(min[i - 1], prices[i]);
           if (prices[i] >= prices[i - 1]) {
               if (i < n - 1 && prices[i] <= prices[i + 1]) {
                   continue;
               }
               res += (prices[i] - min[i]);
               min[i] = Integer.MAX_VALUE;
           }
        }
        return res;
    }
}
