"""

Determine whether an integer is a palindrome. Do this without extra space.

"""

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        x0 = x; out = 0
        while x0:  # while x0/10 or x0%10: also works
            out = out*10 + x0%10
            x0 = x0/10
        return out == x
