class Solution(object): # I prefer to this solution
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums) - 1
        start, end = 0, n
        
        while start <= end:
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
