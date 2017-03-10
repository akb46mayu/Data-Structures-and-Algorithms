"""
Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

"""

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        prevsum = -0xffffffff
        out = nums[0]
        n = len(nums)
        for i in range(n):
            if prevsum < 0:
                prevsum = nums[i] # if previous sum becomes negative, it will find the most recent negative value's idx i-1. and clear sum
            else:
                prevsum += nums[i] # if sum is positivem we continue to add a new number
            out = max(out, prevsum)
        return out
