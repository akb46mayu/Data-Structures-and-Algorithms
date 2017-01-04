"""
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Show Company Tags
Show Tags
Show Similar Problems

"""
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sums = 0
        for x in nums:
            sums = sums^x
        return sums
