"""
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen 
and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Show Tags
Show Similar Problems
"""
# cols is a dictionary which records the col:row pair
# but for printing, it is quite difficult to print according to the def.
# so using the symmetry property, we think of cols as row col pair, and then print (keep in mind)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        results = []
        cols = {}
        self.search(0, cols, n, results)
        return results
        
    def search(self, row, cols, n, results):
        if row == n:
            result = []
            for i in range(n):
                a = ['.']*n
                a[cols[i]] = 'Q'
                result.append(''.join(a))
            results.append(result)
        else:   
            for col in range(n):
                if col in cols:
                    continue
                if self.attack(row, col, cols):
                    continue
                cols[col] = row
                self.search(row+1, cols, n, results)
                del cols[col]
                    
    def attack(self, row, col, cols):
        for c,r in cols.iteritems():
            if col - row == c - r or col + row == c + r:
                return True
        return False
