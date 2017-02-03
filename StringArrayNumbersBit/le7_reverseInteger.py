"""
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321


"""
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        x0 = abs(x)
        i = 0
        out = 0
        if x == 0:
            return 0
        while x0/10 != 0 or x0%10!=0:
             out = out*10 + (x0%10)  
             x0 = x0/10
             i += 1
             
        
        if out > 0x7fffffff:
            return 0
        
        
        return out if x>0 else -out
