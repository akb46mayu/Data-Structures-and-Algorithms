"""

Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.

"""

from heapq import heappush, heappop
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        myheapq = []
        def push(i,j):
            if i < len(matrix) and j < len(matrix[0]):
                heappush(myheapq, [matrix[i][j], i, j])
        push(0,0)
        while k > 0 and myheapq:
            cursmallest, i, j,  = heappop(myheapq)
            push(i, j+1)  # push one element from the poped element's nbh
            if j == 0: # deal with the 0th column case and nbh case
                push(i+1, 0)
            k = k - 1
        return cursmallest
