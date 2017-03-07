"""
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.


"""

from random import randint
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums:
            return -1

        lo, hi = 0, len(nums)-1
        while True:
            pivot_idx = randint(lo, hi)
            j = self.partition(lo, hi, nums, pivot_idx)
            if j == k-1:
                return nums[j]
            elif j < k-1:
                lo = j + 1
            else:
                hi = j - 1 
            
    def partition(self, lo, hi, nums, pivot_idx):
        newpivot_idx = lo
        pivot_val = nums[pivot_idx]
        nums[pivot_idx], nums[hi] = nums[hi], nums[pivot_idx]
        for i in range(lo, hi):
            if nums[i] > pivot_val:
                nums[i], nums[newpivot_idx] = nums[newpivot_idx], nums[i]
                newpivot_idx += 1
        nums[hi], nums[newpivot_idx] = nums[newpivot_idx], nums[hi]
        return newpivot_idx
