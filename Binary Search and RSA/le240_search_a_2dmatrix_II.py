class Solution(object): # start from the upper right corner
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        M, N = len(matrix), len(matrix[0])
        if M == 0 or N == 0:
            return False
        i,j = 0, N-1
        
        while i<=M-1 and j>=0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                i = i + 1
            else:
                j = j - 1
        return False
        
        
class Solution2(object): # start from the lower left corner
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        M = len(matrix)
        N = len(matrix[0])       
        if M == 0:
            return False
        if N == 0:
            return False
        i,j = M - 1, 0
        
        while i >= 0 and j <= N-1:
                if target == matrix[i][j]:
                    return True
                elif target > matrix[i][j]:
                    j = j + 1
                else:
                    i = i - 1
        return False
