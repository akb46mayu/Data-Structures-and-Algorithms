"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
"""


class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        maxreach = 0 # index
        if n == 1:
            return True
        for i in range(n-1):
            maxreach = max(i + nums[i], maxreach)
            if maxreach <= i:
                return False
        return True
        
 class Solution2(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        reachable = 0
        for i, val in enumerate(nums):
            if i > reachable:
                return False
            else:
                reachable = max(reachable, i + val)
        return True
