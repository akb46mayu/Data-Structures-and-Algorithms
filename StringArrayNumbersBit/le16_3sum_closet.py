
"""
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Show Company Tags
Show Tags
Show Similar Problems

"""

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        i, diff, result = 0, sys.maxint, sys.maxint
        n = len(nums)
        nums.sort()
        while i < n-2:
            j, k = i+1, n-1
            while j < k and (i==0 or nums[i]!=nums[i-1]):
                cursum = nums[i] + nums[j] + nums[k]
                if abs(cursum-target) < abs(diff):
                        diff = cursum - target
                        result = cursum
                if cursum < target:
                    j += 1
                elif cursum > target:
                    k -= 1
                else:
                    return cursum
            i += 1
        return result
