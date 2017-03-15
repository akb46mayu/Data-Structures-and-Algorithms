"""
Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.

 Notice

There is at least one subarray that it's sum equals to zero.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
                    

"""

class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers includes the index of the first number 
             and the index of the last number
    """
    def subarraySum(self, nums):
        # write your code here
        if not nums:
            return [-1, -1]
        n = len(nums)
        dict = {0:-1}
        sumv = 0
        for i in range(n):
            sumv += nums[i] 
            if sumv in dict:
                return [dict[sumv]+1 ,i]
            dict[sumv] = i
        return [-1, -1]
                    
