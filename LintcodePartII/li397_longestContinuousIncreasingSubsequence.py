"""
Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice

O(n) time and O(1) extra space.

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.


"""

class Solution:
    # @param {int[]} A an array of Integer
    # @return {int}  an integer
    def longestIncreasingContinuousSubsequence(self, A):
        # Write your code here
        nums = A
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return 1
        curmaxl = 1
        out = 0
        for i in range(1,n):
            if nums[i] >= nums[i-1]:
                curmaxl += 1
            else:
                curmaxl = 1
            out = max(out, curmaxl)
        curmaxl = 1
        for i in range(n-2,-1, -1):
            if nums[i] >= nums[i+1]:
                curmaxl += 1
            else:
                curmaxl = 1
            out = max(out, curmaxl)
        return out
