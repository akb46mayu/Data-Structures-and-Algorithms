"""
Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.


"""

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        res = [[0] * n for j in range(m)]
        out = 0
        for i in range(m):
            for j in range(n):
                 if (i == 0 and j == 0) or (i == 0) or (j == 0):
                     res[i][j] = int(matrix[i][j])
                 else:
                     res[i][j] = min(res[i-1][j], res[i][j-1], res[i-1][j-1]) + 1 \
                                 if int(matrix[i][j]) ==  1 else 0
                 out = max(out, res[i][j])
        return out**2
