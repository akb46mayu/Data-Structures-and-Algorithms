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
        
        
 class Solution2(object):  # Nine chapter's template sol
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 :
            return False
        m = len(matrix) # number of rows 
        n = len(matrix[0])
        start, end = 0, m*n - 1
        while start+1 < end:
            mid = (start + end)/2
            x,y = mid/n, mid%n
            if matrix[x][y] <= target:
                start = mid
            else :
                end = mid
                
        x,y = start/n, start%n
        if matrix[x][y] == target:
          return True
            
        x,y = end/n, end%n
        if matrix[x][y] == target:
          return True
        return False
