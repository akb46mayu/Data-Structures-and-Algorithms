"""

Implement pow(x, n).

"""

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        out = 1
        absn = abs(n)
        while absn:
            if absn&1:
                out *= x
            absn = absn>> 1
            x = x*x
        return 1/out if n<0 else out
