class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        numrows = len(grid)
        numcols = len(grid[0])
        
        for i in xrange(numrows):
            for j in xrange(numcols):
                if i==0 and j>0:
                    grid[i][j]+= grid[i][j-1] 
                elif j==0 and i>0:
                    grid[i][j]+= grid[i-1][j]
                elif j>0 and i>0:
                    grid[i][j]+= min(grid[i-1][j], grid[i][j-1]) 
                else:
                    grid[0][0] = grid[0][0]
        return grid[numrows-1][numcols-1]
