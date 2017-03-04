"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

"""

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        if n == 0:
            return 0
        left, right = 0, n-1
        out = 0
        lmax, rmax = height[left], height[right]
        while left < right:
            if lmax < rmax:
                left += 1
                if height[left] < lmax:
                    out += lmax - height[left]
                else:
                    lmax = height[left]
            else:
                right -= 1
                if height[right] < rmax:
                    out += rmax - height[right]
                else:
                    rmax = height[right]
        return out
