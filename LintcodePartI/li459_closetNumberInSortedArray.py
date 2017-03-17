"""
Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

Return -1 if there is no element in the array.

 Notice

There can be duplicate elements in the array, and we can return any of the indices with same value.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.


"""


class Solution:  # O(n) TLE
    # @param {int[]} A an integer array sorted in ascending order
    # @param {int} target an integer
    # @return {int} an integer
    def closestNumber(self, A, target):
        # Write your code here
        if A is None or target is None:
            return -1

        n = len(A)
        ans = -1
        mindiff = sys.maxint
        for i in range(n):
            curdiff = abs(A[i] - target)
            if curdiff < mindiff:
                if curdiff == 0:
                    return i
                mindiff = curdiff
                ans = i
        return ans
