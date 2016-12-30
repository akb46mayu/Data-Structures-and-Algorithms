
"""
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
"""


class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        obs = obstacleGrid
        f = [[0]*n]*m
        for i in range(m):
            for j in range(n):
                if i ==0 and j == 0:
                    f[0][0] = 1 if obs[0][0]==0 else 0
                elif i==0:
                    f[i][j] = f[i][j-1] if obs[i][j]==0 else 0
                elif j==0:
                    f[i][j] = f[i-1][j] if obs[i][j]==0 else 0
                else:
                    f[i][j] = f[i-1][j] + f[i][j-1] if obs[i][j] ==0 else 0
        return f[m-1][n-1]
