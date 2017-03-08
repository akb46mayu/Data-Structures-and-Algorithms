"""

Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

"""

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0 
        n = len(nums)
        r = 0
        kmin = n + 1
        sum = 0
        for i in range(n):
            while sum < s and r <= n-1:
                sum += nums[r]
                r += 1
            if sum >= s:
                kmin = min(kmin, r - i)
            sum -= nums[i]
        return 0 if kmin == n + 1  else kmin
