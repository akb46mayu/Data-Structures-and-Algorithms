"""
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. 
Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle 
that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Show Company Tags
Show Tags

"""

class Solution(object):
    def minArea(self, image, x, y):
        """
        :type image: List[List[str]]
        :type x: int
        :type y: int
        :rtype: int
        """
        if not image:
            return 0
        if len(image) == 0 or len(image[0]) == 0:
            return 0
        m,n = len(image), len(image[0])
       
        left = self.computeL(image, 0, y)
        right = self.computeR(image, y, n-1)
        up = self.computeU(image, 0, x)
        down = self.computeD(image, x, m-1)
        return (down - up + 1) * (right - left + 1)
        
    def computeL(self, image, start, end):
        
        while start + 1 < end:
            mid = start + (end - start)/2
            if self.checkColEmpty(image, mid):
                start = mid
            else:
                end = mid
        if self.checkColEmpty(image, start):
            return end
        else:
            return start
    
    def computeR(self, image, start, end):
        
        while start + 1 < end:
            mid = start + (end - start)/2
            if self.checkColEmpty(image, mid):
                end = mid
            else:
                start = mid
        if self.checkColEmpty(image, end):
            return start
        else:
            return end        
            
            
    def computeU(self, image, start, end):
        
        while start + 1 < end:
            mid = start + (end - start)/2
            if self.checkRowEmpty(image, mid):
                start = mid
            else:
                end = mid
        if self.checkRowEmpty(image, start):
            return end
        else:
            return start
    
                
    def computeD(self, image, start, end):
        
        while start + 1 < end:
            mid = start + (end - start)/2
            if self.checkRowEmpty(image, mid):
                end = mid
            else:
                start = mid
        if self.checkRowEmpty(image, end):
            return start
        else:
            return end   
        
        
    def checkColEmpty(self, image, col):
        m, n = len(image), len(image[0])
        for i in range(m):
            if image[i][col] == '1':
                return False
        return True
        
    def checkRowEmpty(self, image, row):
        m, n = len(image), len(image[0])
        for j in range(n):
            if image[row][j] == '1':
                return False
        return True
