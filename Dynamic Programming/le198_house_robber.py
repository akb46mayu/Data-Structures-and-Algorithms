"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
"""


class Solution(object): # save more space
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:  # when nums is None or empty 
            return 0
        n = len(nums)
        if n == 1: # when it has one element
            return nums[0]
        f = [0, 0]
        f[1] = nums[0]
        for i in range(2,n+1):
            f[i%2] = max(f[(i-1)%2], nums[i-1] + f[(i-2)%2])
        return f[n%2]
    
class Solution2(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        f = [0] * (n+1)
        f[1] = nums[0]
        for i in range(2,n+1):
            f[i] = max(f[i-1], nums[i-1] + f[i-2])
        return f[n]
