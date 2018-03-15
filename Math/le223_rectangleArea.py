"""

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
(A,B), (C,D)  (E,F) (G,H)
Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

"""


class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        s1 = (C-A)*(D-B)
        s2 = (G-E)*(H-F)
        width = self.intersect(A,C,E,G);
        height = self.intersect(F,H, B,D);
        return s1+s2 - width * height
    def intersect(self, x1, x2, x3, x4):
        if x1>x3:
            x1, x3= x3, x1
            x2, x4 = x4, x2
        if x3<=x2 and x2<=x4:
             out = x2 -x3 
        elif x4<=x2:
            out = x4-x3
        else: # x3>x2
            out = 0
        return out
# EASIER SOLUTION LOOK the others
class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        area1 = abs((A -C) * (B - D))
        area2 = abs((E - G) * (F - H))
        if C < E or G < A or B > H or F > D:
            return area1 + area2
        else:
            list1 = [A, C, E, G]
            list2 = [B, D, F, H]
            list1.sort()
            list2.sort()
            area3 = (list1[2] - list1[1]) * (list2[2] - list2[1])
            return area1 + area2 - area3
