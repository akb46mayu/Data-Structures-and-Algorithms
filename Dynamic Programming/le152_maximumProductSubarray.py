"""
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.


"""


class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        localmin, localmax, globalmax = 1, 1, -0xffffffff
        for x in nums:
            localmax = max(localmax, 1) # keep localmax always 1 (prevent from 0 case)
            if x > 0:
                localmax, localmin = x*localmax, x*localmin
            else:
                localmax, localmin = x*localmin, x*localmax
            globalmax = max(globalmax, localmax)
        return globalmax
