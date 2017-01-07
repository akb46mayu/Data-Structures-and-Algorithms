"""
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
Show Company Tags
Show Tags
Show Similar Problems


"""
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        out = []
        n = len(nums)
        i = 0
        nums.sort()
        while i < n-2:
            j, k = i+1, n-1
            while j<k and (i == 0 or nums[i]!=nums[i-1]):
                    s = nums[i] + nums[j] + nums[k]
                    if s < 0 :
                        j +=1
                    elif s > 0:
                        k -=1
                    else:
                        out.append([nums[i],nums[j],nums[k]])
                        j, k = j +1, k-1
                        while j<k and nums[j]==nums[j-1]:
                                j +=1
                        while j<k and nums[k]== nums[k+1]:
                                k -=1
                    
            i += 1
        return out
