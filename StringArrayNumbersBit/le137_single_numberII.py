"""
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

"""




class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        d = [0 for i in range(32)]
        for x in nums:
            for j in range(32):
                if (x & (1<<j)) > 0:
                    d[j]+=1
                    d[j] = d[j]%3
        if d[31] == 1:
            for i in range(31):
                t = d[i]^1
                if t == 1:
                     ans = ans + (1<<i)
            ans = -(ans + 1)
        else:
            for i in range(32):
                if d[i] == 1:
                    ans = ans + (1<<i)
            
        return ans
