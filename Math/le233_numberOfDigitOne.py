"""
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
"""

class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        m = 1
        out = 0 
        while m <= n:
            a = n/m; b = n%m
            out += ((a+8)/10)*m + (a%10 == 1)*(b+1)
            m *= 10
        return out 
