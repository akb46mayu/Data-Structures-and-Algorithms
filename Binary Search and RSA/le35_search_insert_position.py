class Solution(object): # method 1, Nine chapter's sol
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        start, end = 0, len(nums)-1
        while start + 1< end:
            mid = start + (end - start)/2
            if nums[mid] < target:
                start = mid
            else:
                end = mid
        if nums[start] >= target:
            return start
        if nums[end] >= target:
            return end
        return len(nums)
        
class Solution2(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = (start + end)/2
            if nums[mid] >= target:
                end = mid - 1                
            else:
                start = mid + 1
        return start
