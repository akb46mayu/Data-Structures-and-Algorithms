"""
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
"""
# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        n = len(points)
        if n<=2:
            return n
        maxnum = 0
        for i in range(n):
            coordinates = {}
            dup_counts = 1
            p1 = points[i]
            dup_counts = 1
            curmax = 0
            for j in range(i+1, n):
                p2 = points[j]
                dx = p2.x - p1.x
                dy = p2.y - p1.y
                if dx==0 and dy==0:
                    dup_counts += 1
                    continue
                gcd = self.gcdCompute(dx, dy)
                dx //= gcd
                dy //= gcd
                coordinates[(dx,dy)] = coordinates[(dx,dy)]+1 if (dx,dy) in coordinates.keys() else 1
                curmax = max(curmax, coordinates[(dx,dy)])
            maxnum = max(maxnum, dup_counts+ curmax)
        return maxnum
    def gcdCompute(self, a, b):
        if b==0: 
            return a
        else:
            return self.gcdCompute(b, a%b)
