"""

Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number.
Please return the number of pairs.

Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)

"""

class Solution:
    # @param nums, an array of integer
    # @param target, an integer
    # @return an integer
    def twoSum2(self, nums, target):
        # Write your code here 
        i, j = 0, len(nums)-1
        nums.sort()
        res = 0
        while i < j:
            if nums[i] + nums[j] > target:
                res += j-i
                j -= 1
            else:
                i += 1
        return res
