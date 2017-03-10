"""
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.


"""

class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        L = [0]*n
        R = [n]*n
        H = [0]*n
        result = 0
        for i in range(m):
            left = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    L[j] = max(L[j], left)
                    H[j] += 1
                else:
                    R[j] = n
                    H[j] = 0
                    L[j] = 0
                    left = j + 1
            right = n
            for j in reversed(range(n)):
                if matrix[i][j] == '1':
                    R[j] = min(R[j], right)
                    result = max(result, H[j]*(R[j] - L[j]))
                else:
                    right = j 
               
        return result
