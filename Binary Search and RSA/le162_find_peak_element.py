"""
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.
"""

class Solution(object): # I prefer to this solution (no duplicates)
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums) - 1
        start, end = 0, n
        
        while start <= end:  # this can also be start < end, it does not matter
            mid = (start + end)/2
            if (mid==0 or nums[mid] > nums[mid-1]) and (mid == n or nums[mid] > nums[mid+1]):
                return mid
            elif (mid!=0 and nums[mid] < nums[mid-1]):
                end = mid - 1
            else:
                start = mid + 1
        return start
    
    
class Solution2(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums)-1
        n = len(nums) - 1
        while start < end:
            mid = (start + end)/2
            if (mid==0 or nums[mid] > nums[mid-1]) and (mid == n or nums[mid] > nums[mid+1]):
                return mid
            elif (mid!=0 and nums[mid] < nums[mid-1]):
                end = mid
            else:
                start = mid + 1  # if not use this (say start = mid), when nums=[1,2], it will loop forever
        return start
    
class Solution3(object): # nine chapter's template
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1
        n = len(nums)
        
        left, right = 0, n-1
        while left + 1 < right:
            mid = left + (right - left)/2
            if (mid == 0 or nums[mid] > nums[mid+1]) and (mid == n-1 or nums[mid] > nums[mid-1]): # when mid =0 or n-1
                return mid
            elif (nums[mid] < nums[mid-1]): # in fact mid!=0
                right = mid
            elif (nums[mid] < nums[mid+1]): #mid + 1!= n-1
                left = mid
            else:
                right = mid
        if nums[left] > nums[right]:
            return left
        else:
            return right
