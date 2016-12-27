"""
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

"""

class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        sol = [0]
        cols = {}
    
        self.search(0, cols, sol, n)
        return sol[0]
    def search(self, row, cols, sol, n):
        if row == n:
            sol[0]+=1
        else:
            for col in range(n):
                if col in cols:
                    continue
                if self.attack(row, col, cols):
                    continue
                cols[col] = row
                self.search(row+1, cols, sol, n)
                del cols[col]
    
    def attack(self, row, col, cols):
        for c, r in cols.iteritems():
            if c - r == col - row or c + r == col + row:
                return True
        return False
