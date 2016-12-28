"""
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
Show Company Tags
Show Tags
Show Similar Problems
"""

# the candidate set does not have duplicate elements, and results should not have duplications. (that's why we use sort)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        results = []
        candList = []
        candidates.sort()
        self.sumHelper(candidates, target, 0, candList, results)
        return results
    def sumHelper(self, candidates, target, start, candList, results):
         if target == 0:
            results.append(candList)
            #candList = []  # why candList does not need to be reset to []?
            return
         
         for i in range(start, len(candidates)):
             if target < candidates[i]:
                return
             self.sumHelper(candidates, target - candidates[i], i, candList+[candidates[i]], results)
