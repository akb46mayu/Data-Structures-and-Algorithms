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


class Solution2(object):  
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        temp = []
        self.subHelper(nums, temp, res, 0)
        return res
    
    def subHelper(self, nums, temp, res, level):
        n = len(nums)
        if level == n:
            res.append(list(temp)) # when you append a list ref, do not forget to make it entity
            return
        temp.append(nums[level])
        self.subHelper(nums, temp, res, level + 1)
        temp.pop()
        self.subHelper(nums, temp, res, level + 1)
