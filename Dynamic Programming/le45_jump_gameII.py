"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

"""

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0 or n==1:
            return 0
        
        curReachable = 0
        reachable = 0
        steps = 0
        for i,val in enumerate(nums):
            if reachable<i:  # a little different from version I
                return -1
            if curReachable < i:
                steps+=1
                curReachable = reachable
            reachable = max(reachable, val+i)
        return steps

    
######## dp TLE solution    
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) <= 1:
            return 0
        n = len(nums)
        dp = [0] * n
        for j in range(1, n):
            dp[j] = j
            for i in range(0, j):
                if i + nums[i] >= j:
                    dp[j] = min(dp[j], dp[i] + 1)
        return dp[n - 1]
    
