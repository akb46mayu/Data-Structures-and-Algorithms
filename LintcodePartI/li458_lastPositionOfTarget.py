"""
Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.


"""


class Solution:
    # @param {int[]} A an integer array sorted in ascending order
    # @param {int} target an integer
    # @return {int} an integer
    def lastPosition(self, A, target):
        # Write your code here
        if not A or not target:
            return -1
        n = len(A)
        left, right = 0, n-1
        while left + 1 < right:
            mid = left + (right - left)/2
            if A[mid] <= target:
                left = mid
            else:
                right = mid
        if A[right] == target:
            return right
        if A[left] == target:
            return left
        return -1
