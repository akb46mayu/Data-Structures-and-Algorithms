class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        results = [[]]
        previousSize = 1
        nums.sort()
        for i in xrange(len(nums)):
                size = len(results)
                for j in xrange(size):
                    if i==0 or  nums[i]!=nums[i-1] or j>=previousSize:
                      results.append(list(results[j]))
                      results[-1].append(nums[i])
                previousSize = size      
        return results   
