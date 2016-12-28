"""
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
"""

class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candList = []
        results = []
        candidates.sort()
        self.sumHelper(candidates, target, 0, candList, results)
        return results
        
    def sumHelper(self, candidates, target, start, candList, results):
        if target == 0 and candList not in results: # dupliations
            results.append(candList)
            return
        else:
            for i in range(start, len(candidates)):
                if target < candidates[i]:
                    return
                self.sumHelper(candidates, target - candidates[i], i+1, candList+[candidates[i]], results)
                
class Solution2(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        candList = []
        results = []
        use = [0]*len(candidates)
        self.sumHelper(candidates, target, 0, candList, use, results)
        return results
    
    def sumHelper(self, candidates, target, start, candList, use, results):
        if target == 0:
            results.append(list(candList)) # or use append(candList[:])
            return
        
        for i in range(start, len(candidates)):
            if target < candidates[i]:
                return 
            if i == 0 or candidates[i-1]!= candidates[i] or use[i-1]==1:
                use[i] = 1
                candList+=[candidates[i]]
                self.sumHelper(candidates, target-candidates[i], i+1, candList, use, results)
                candList.pop()
                use[i] = 0
