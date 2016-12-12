class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        results = [[]]
        
        for i in xrange(len(nums)):
             size = len(results)
             for j in xrange(size):
                results.append(list(results[j]))
                results[-1].append(nums[i])
        
        return results
