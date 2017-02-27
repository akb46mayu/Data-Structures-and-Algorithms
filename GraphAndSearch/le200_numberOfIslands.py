"""
Given a 2d grid map of '1's (land) and '0's (water), 
count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

"""

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        if m == 0:
           return 0
        n = len(grid[0])
        visited = [ [False for j in range(n)] for i in range(m) ]
        def check(x, y):
            if (x>=0 and x<m) and (y>=0 and y < n) and visited[x][y] == False and grid[x][y] == '1':
                return True
            return False
        def dfs(x, y):
            dx = [0, 0, -1, 1]
            dy = [1, -1, 0, 0]
            for i in range(len(dx)):
                newx, newy = x + dx[i], y + dy[i]
                if check(newx, newy):
                    visited[newx][newy] = True
                    dfs(newx, newy)
                    
        cnt = 0
        for i in range(m):
            for j in range(n):
                if check(i, j):
                    dfs(i,j)
                    cnt += 1
        return cnt
