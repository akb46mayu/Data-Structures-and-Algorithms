"""
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
"""
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if heights is None or len(heights) == 0:
            return 0
        
        area = 0
        n= len(heights)
        stack = []
        for i in range(n+1):#  for idx i, compute i-1's (i-2,i-3 if exists) height according to its leftmose(stack[-1]) and rightmost(i) min pillar
            if i == n:
                curHeight = -1
            else:
                curHeight = heights[i]
            while stack and curHeight <= heights[stack[-1]]:
                h = heights[stack.pop()]
                if stack:
                    w = i-1-stack[-1]
                else: # when stack is empty, means sequnce is increasing, which does not have the leftmost element.
                    w = i
                area = max(area, w*h)
            stack.append(i)
        return area
