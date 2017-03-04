"""
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.


After the rain, water are trapped between the blocks. The total volume of water trapped is 4.


"""

from heapq import heappush, heappop
class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        if not heightMap:
            return 0
            
        hq = []
        m,n = len(heightMap), len(heightMap[0])
        out = 0
        dx = [-1, 0, 1, 0]
        dy = [0, -1, 0, 1]
        visited = [[0 for j in range(n)] for i in range(m)]
        for i in range(m):
            heappush(hq, (heightMap[i][0],i,0))
            heappush(hq, (heightMap[i][n-1],i,n-1))
            visited[i][0] = 1
            visited[i][n-1] = 1
        for j in range(n):
            heappush(hq, (heightMap[0][j],0,j))
            heappush(hq, (heightMap[m-1][j],m-1,j))
            visited[0][j] = 1
            visited[m-1][j] = 1
        while hq:
            h, i, j = heappop(hq)
            for k in range(len(dx)):
                newi = i + dx[k]
                newj = j + dy[k]
                if (newi >= 0 and newi < m) and (newj >= 0 and newj< n) and not visited[newi][newj]:
                        newh = heightMap[newi][newj]
                        visited[newi][newj] = 1
                        hsave = max(newh, h)
                        heappush(hq, (hsave, newi, newj))
                        if newh < h:
                            out = out + (h - newh)
                        
        return out
