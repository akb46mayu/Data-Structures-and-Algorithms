"""
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

"""

class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        f = [[0]*n for i in range(m)]
        for i in range(m):
            for j in range(n):
                self.search(matrix, f, i, j)
                
        out = 0
        for i in range(m):
            for j in range(n):
                out = max(out, f[i][j])
        return out
        
    def search(self, matrix, f, i, j):
        m,n = len(matrix), len(matrix[0])
        if f[i][j] != 0:
            return f[i][j]
        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]
        longest = 1
        for k in range(4):
            ni, nj = i + dy[k], j + dx[k]
            if ni<0 or ni >=m or nj <0 or nj >= n:
                continue
            if matrix[i][j] >= matrix[ni][nj]:
                continue
            longest = max(self.search(matrix, f, ni, nj) + 1, longest)
        f[i][j] = longest
        return f[i][j]
