"""
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
"""



class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        nums.sort()
        low = nums[0]
        templen = 1
        maxlen = 1
        
        for val in nums:
            if val == low:
                continue
            elif val - low == 1:
                templen+=1
                if templen > maxlen:
                    maxlen = templen
            else:
                templen = 1
            low = val
        return maxlen
