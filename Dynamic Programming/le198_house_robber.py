"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
"""


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        if n == 0:
            return 0
        f = [0]*n
        for i in range(n):
            if i==0:
                f[i] = nums[i]
            elif i == 1:
                f[i] = max(nums[i], nums[i-1])
            else:
                f[i] = max(nums[i]+f[i-2], f[i-1])
        return f[n-1]

class Solution2(object):# in place
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        if n == 0:
            return 0
      
        for i in range(n):
            if i==0:
                nums[i] = nums[i]
            elif i == 1:
                nums[i] = max(nums[i], nums[i-1])
            else:
                nums[i] = max(nums[i]+nums[i-2], nums[i-1])
        return nums[n-1]
