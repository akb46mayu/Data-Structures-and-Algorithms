"""

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

"""
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        hashmap = {}
        while 1:
            hashmap[n] = 1
            n = self.nextEle(n)
            if n == 1 or n in hashmap:
                break
        return n==1
                
            
            
            
            
    def nextEle(self, x):
        out = 0
        while x/10 or x%10:
            out = out +  (x%10)**2
            x = x/10
        return out
