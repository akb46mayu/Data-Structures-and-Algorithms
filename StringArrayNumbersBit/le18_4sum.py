"""
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Show Tags
Show Similar Problems


"""
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        n = len(nums)
        out = []
        i = 0
        nums.sort()
        for i in range(n-3):
            if i>=1 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1, n-2):
                if j>=i+2 and nums[j] == nums[j-1]:
                    continue
                l, r = j+1, n-1
                sum0 = target - (nums[i] + nums[j])
                while l< r:
                    if sum0 == nums[l] + nums[r]:
                        out.append([nums[i], nums[j], nums[l], nums[r]])
                        l, r = l+1, r-1
                        while l<r and nums[l] == nums[l-1]:
                            l += 1
                        while l<r and nums[r] == nums[r+1]:
                            r -= 1
                    elif sum0 > nums[l] + nums[r]:
                        l += 1
                    else:
                        r -= 1
        return out
