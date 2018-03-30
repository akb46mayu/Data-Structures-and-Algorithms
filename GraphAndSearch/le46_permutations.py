"""
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
"""

class Solution(object): # use DFS implemented by recursion
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums is None:  # this is not needed for passing OJ
            return []
        results = [] 
        self.permuteHelper(results, [], nums)
        return results
    
    def permuteHelper(self, results, temp, nums):
        if nums == []:
            results+= [temp]
        else:
            for i in range(len(nums)):
                self.permuteHelper(results, temp+[nums[i]], nums[:i] + nums[i+1:])

                
## permutations                 
class Solution2(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.permuteHelper(nums, res, 0)
        return res
    
    def permuteHelper(self, nums, res, k):
        n = len(nums)
        if k == n:
            res.append(list(nums))
            return
        for j in range(k, n):
            nums[k], nums[j] = nums[j], nums[k]
            self.permuteHelper(nums, res, k + 1)
            nums[k], nums[j] = nums[j], nums[k]
