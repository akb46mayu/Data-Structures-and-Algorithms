"""
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


"""
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n <=1:
            return 0
        p1, p2 = [0]*n, [0]*n
        minp = prices[0]
        for i in range(1, n):
            minp = min(minp, prices[i])
            p1[i] = max(p1[i-1], prices[i]-minp)
        maxp = prices[-1]
        for i in range(n-2, -1, -1):
            maxp = max(maxp, prices[i])
            p2[i] = max(p2[i+1], maxp- prices[i])
        ans = 0
        for i in range(n):
            ans = max(ans, p1[i] + p2[i])
        return ans
        
