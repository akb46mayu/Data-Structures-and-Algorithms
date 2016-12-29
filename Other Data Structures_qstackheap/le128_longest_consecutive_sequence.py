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

class Solution2(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 1
        nums.sort()
        n = len(nums)
        i = 0
        maxlen = 1
        while i < n:
            tmplen = 1
            while i<=n-2 and nums[i+1] - nums[i] <=1:
                if nums[i+1] - nums[i] == 1:
                    tmplen+=1
                i = i + 1
            maxlen = max(maxlen, tmplen)
            i = i + 1
        return maxlen
