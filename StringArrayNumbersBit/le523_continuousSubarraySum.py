"""
Given a list of non-negative numbers and a target integer k, 
write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, 
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
Show Company Tags
Show Tags
"""

class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if not nums:
            return False
        
        sumv = 0
        dict = {0:-1}
        n = len(nums)
        for i in range(n):
            sumv += nums[i]
            if i >= 1 and nums[i] == 0 and nums[i-1] == 0:
                return True
            reducedsum =  self.reduceHelper(sumv, k) if k!= 0 else sumv
            if reducedsum in dict:
               if i != dict[reducedsum] + 1:
                  return True
            else:
               dict[reducedsum] = i
        return False
        
    def reduceHelper(self, sumv, k):
        if sumv % abs(k) == 0:
            return 0
        else:
            return abs(k) - sumv%abs(k)
