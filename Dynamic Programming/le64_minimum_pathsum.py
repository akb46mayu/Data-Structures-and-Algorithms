"""
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
"""

class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if i ==0 and j==0:
                   continue
                elif i==0:
                   grid[i][j] = grid[i][j] + grid[i][j-1]
                elif j==0:
                   grid[i][j] = grid[i][j] + grid[i-1][j]
                else:
                   grid[i][j] = grid[i][j] + min(grid[i-1][j], grid[i][j-1])
        return grid[m-1][n-1]

    
class Solution2(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        f = [[0]*n]*m
        for i in range(m):
            for j in range(n):
                if i ==0 and j==0:
                   f[i][j] = grid[i][j]
                elif i==0:
                   f[i][j] = grid[i][j] + f[i][j-1]
                elif j==0:
                   f[i][j] = grid[i][j] + f[i-1][j]
                else:
                   f[i][j] = grid[i][j] + min(f[i-1][j], f[i][j-1])
        return f[m-1][n-1]
