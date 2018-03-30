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
   
   
## solution 2 
from heapq import heappush, heappop
class Solution2(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        if matrix is None or len(matrix) == 0:
            return None
        m, n = len(matrix), len(matrix[0])
        pq = []
        visited = [[False] * n for i in range(m)]
        visited[0][0] = True
        heappush(pq, (matrix[0][0], 0, 0))
        while k > 0:
            cur, x, y = heappop(pq)
            dx = [0, 1]
            dy = [1, 0]
            for p in range(2):
                nx = x + dx[p]
                ny = y + dy[p]
                if nx >= 0 and nx < m and ny >= 0 and ny < n and visited[nx][ny] == False:
                    heappush(pq, (matrix[nx][ny], nx, ny))
                    visited[nx][ny] = True
            k -= 1
        return cur
