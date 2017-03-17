"""

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.
"""


class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) <= 1:
            return 0
        n = len(nums)
        maxi, mini = max(nums), min(nums)
        if maxi == mini:  # if all elements are the same, max gap is 0
            return 0
        bsize = max(1,(maxi - mini)/ (n-1))  # when bucket size is 0, update it to 1 (denominator)
        k = (maxi-mini)/bsize + 1 # number of buckets(this is different from the formula)
        localmin = [-1]*k
        localmax = [-1]*k
        flag = [0]*k
        for i in range(n):
            t = (nums[i] - mini)/bsize
            flag[t] = 1
            localmin[t] = self.min(nums[i], localmin[t])
            localmax[t] = self.max(nums[i], localmax[t])
            #print t, localmin[t], localmax[t]
        globalmax = 0
        prevmax = mini  # rethink about this
        for t in range(0,k):
            if flag[t] == 0:
                continue
            globalmax = max(globalmax, localmin[t] -  prevmax)
            prevmax = localmax[t]
        return globalmax     
        
    def min(self, a, b):
        if a == -1: return b
        if b == -1: return a
        if a < b: return a
        else: return b
    def max(self, a, b):
        if a == -1: return b
        if b == -1: return a
        if a > b: return a
        else: return b
