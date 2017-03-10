"""
tag: dp, binary search
concept: longest increasing subsequence


Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
"""
class Solution(object): # T= O(n^2)
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        f = [1] * n
        for i, val in enumerate(nums):
            for cur in range(i):
                if nums[cur] < val:
                    f[i] = max(f[cur]+1, f[i])
        return max(f)
