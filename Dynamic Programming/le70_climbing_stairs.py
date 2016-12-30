"""
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Show Company Tags
Show Tags

"""
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==0 or n==1:
            return 1
        prev1, prev2, out = 1, 1, 0
        for i in range(2,n+1):
            out = prev1 + prev2
            prev1 = prev2
            prev2 = out            
        return out

class Solution2(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        f = [0 for _ in range(n+1)]
        f[0], f[1] = 1, 1
        for i in range(n+1):
            if i>=2:
              f[i] = f[i-1] + f[i-2]           
        return f[n]
