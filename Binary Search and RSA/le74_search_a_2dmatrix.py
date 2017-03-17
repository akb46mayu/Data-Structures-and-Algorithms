class Solution(object):
    def searchMatrix(self, matrix, target): # the number is unique, no duplications. Following method is better
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        numr, numc = len(matrix), len(matrix[0])
        
        if numr*numc == 0:
            return False
        start, end = 0, numr*numc - 1
        while start<= end:
            mid = (start + end)/2
            x, y = mid/numc, mid%numc
            if matrix[x][y] < target:
                start = mid + 1
            elif matrix[x][y] > target:
                end = mid - 1
            else:
                return True
        return False
        
        
class Solution2(object):
    def searchMatrix(self, matrix, target): # leetcode seems to improve its test cases by adding the corner case [] and [[]]
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        if matrix == [] or matrix == [[]]:
            return False
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m*n - 1
        while left + 1 < right:
            mid = left + (right - left)/2
            row, col = mid / n, mid % n
            if matrix[row][col] < target:
                left = mid
            else:
                right = mid
        row, col = left / n, left % n
        if matrix[row][col] == target:
            return True
        row, col = right/n, right % n
        if matrix[row][col] == target:
            return True
        return False
