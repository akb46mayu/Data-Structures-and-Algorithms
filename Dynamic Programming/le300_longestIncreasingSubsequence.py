"""
tag: dp, binary search
concept: longest increasing subsequence

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
