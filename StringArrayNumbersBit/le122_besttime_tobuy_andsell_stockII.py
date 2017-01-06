
"""
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
"""

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n == 0 or n == 1:
            return 0
        f = [0]*(n+1)
        f[0], f[1] = 0, 0 
        for i in range(2, n+1):
            f[i] = max(f[i-1], prices[i-1] - prices[i-2] + f[i-1])
        return f[n]
