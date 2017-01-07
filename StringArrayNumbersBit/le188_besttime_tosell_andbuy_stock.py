"""
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

"""
class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n<=1 or k == 0:
            return 0
        ans = 0
        if k >= n/2:
            for i in range(1, n):
               diff = prices[i] - prices[i-1]
               ans = max(ans, diff + ans)
            return ans
        localp = [[0]*(k+1) for i in range(n)]
        globalp = [[0]*(k+1) for i in range(n)]
        for i in range(1, n):
            for j in range(1, k+1):
                diff = prices[i] - prices[i-1]
                localp[i][j] = max(globalp[i-1][j-1], localp[i-1][j]+diff)
                globalp[i][j] = max(globalp[i-1][j], localp[i][j])
        return globalp[n-1][k]
