"""
Given an integer matrix, find a submatrix where the sum of numbers is zero. 
Your code should return the coordinate of the left-up and right-down number.

Have you met this question in a real interview? Yes
Example
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]

"""

class Solution:
    # @param {int[][]} matrix an integer matrix
    # @return {int[][]} the coordinate of the left-up and right-down number
    def submatrixSum(self, matrix):
        # Write your code here
        if not matrix:
            return [[0,0], [0,0]]
        m, n = len(matrix), len(matrix[0])
        psum = [[0]*n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if i == 0:
                    psum[i][j] = matrix[i][j]
                else:
                 psum[i][j] = psum[i-1][j] + matrix[i][j]
       
        for lx in range(m):
            for rx in range(lx, m):
                dict = {0:-1}
                sum0 = 0
                for j in range(n):
                    sumcur = psum[rx][j] - psum[lx-1][j] if lx >= 1 else psum[rx][j]
                    sum0 += sumcur
                    if sum0 in dict:
                        return [[lx,dict[sum0]+1],[rx,j]]
                    dict[sum0] = j
        return [[0,0], [0,0]]
