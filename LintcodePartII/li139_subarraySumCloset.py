"""

Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
"""

class Node:
    def __init__ (self, val, pos):
        self.val = val
        self.pos = pos
    def __cmp__ (self, other): # this function will be called when running the sort function
        if self.val == other.val:
            return self.pos - other.pos
        return self.val - other.val
        
class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers includes the index of the first number 
             and the index of the last number
    """
    def subarraySumClosest(self, nums):
        # write your code here
        if not nums:
            return [-1, -1]
        n = len(nums)

        snode = []
        snode.append(Node(0,-1))
        sumv = 0
        for i in range(n):
            sumv += nums[i]
            snode.append(Node(sumv, i))
        snode.sort()

        result = [0, 0]
        mindiff = sys.maxint
        for i in range(n-1):
            if snode[i+1].val - snode[i].val < mindiff or snode[i+1].val - snode[i].val == mindiff\
               and min(snode[i+1].pos, snode[i].pos) + 1 < result[0]:
               
               mindiff = snode[i+1].val - snode[i].val
               result[0] = min(snode[i+1].pos, snode[i].pos) + 1
               result[1] = max(snode[i+1].pos, snode[i].pos)
        return result
