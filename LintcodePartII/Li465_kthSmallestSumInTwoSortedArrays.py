"""

Given two integer arrays sorted in ascending order and an integer k. 
Define sum = a + b, where a is an element from the first array and b is an element from the second one. 
Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.

"""

from heapq import heappush, heappop
class Solution:
    # @param {int[]} A an integer arrays sorted in ascending order
    # @param {int[]} B an integer arrays sorted in ascending order
    # @param {int} k an integer
    # @return {int} an integer
    def kthSmallestSum(self, A, B, k):
        # Write your code here
        myheapq = []
        def push(i, j):
            if i < len(A) and j < len(B):
                heappush(myheapq, [A[i] + B[j], i, j])
        push(0, 0)
        while k > 0 and myheapq:
            kthSmallSum, i, j = heappop(myheapq)
            push(i, j+1)
            if j == 0:
                push(i+1, 0)
            k -= 1
        return kthSmallSum
