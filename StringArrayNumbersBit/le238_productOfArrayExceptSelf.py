"""
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product 
of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space 
for the purpose of space complexity analysis.)

"""

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        rightPd = [0 for i in range(n+1)]
        out = []
        rightPd[n] = 1
        for i in xrange(n-1, 0, -1):
            rightPd[i] = rightPd[i+1]*nums[i]
        leftPd = 1
        for i in range(n):
            out.append(leftPd*rightPd[i+1])
            leftPd = leftPd*nums[i]
        return out
