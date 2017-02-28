"""

A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

"""

class Solution(object):
    def numIslands2(self, m, n, positions):
        """
        :type m: int
        :type n: int
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        self.f = [-1 for i in range(m*n)]
        res = []
        area = 0
        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]
        for k in range(len(positions)):
            x, y = positions[k][0], positions[k][1]
            idx = x*n + y
            if self.f[idx] == -1:
                area += 1
                self.f[idx] = idx
            for p in range(len(dx)):
                newx, newy = x + dx[p], y + dy[p]
                newidx = newx*n + newy
                if self.inboard(m, n, newx, newy):
                    if self.merge(idx, newidx):
                        area -=1
            res.append(area)
        return res
        
    def inboard(self,m,n, x, y):
        return x >= 0 and x<m and y>=0 and y<n
    
    def merge(self, i, j):
        if self.f[i]==-1 or self.f[j]==-1:
            return False
        i = self.find(self.f[i])
        j = self.find(self.f[j])
        if i != j:
            self.f[i] = j
            return True
        return False
    
    def find(self, i):
        if i == self.f[i]:
            return i
        return self.find(self.f[i])
