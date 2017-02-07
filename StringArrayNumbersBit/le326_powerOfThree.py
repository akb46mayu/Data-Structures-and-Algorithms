"""

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

"""

import math
class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        maxlog3 = int(math.log(0x7fffffff)/math.log(3))
        maxpow3 = 3**maxlog3
        return n>0 and maxpow3%n == 0
