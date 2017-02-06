"""

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

"""


class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        out = 0
        while n/5 > 0:
            out = out + n/5
            n = n/5
        return out
