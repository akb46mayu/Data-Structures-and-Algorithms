class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # find the leftmost element (Nine Chapter's template)
        if len(nums)==0:
            return [-1, -1]
        start, end = 0, len(nums)-1
        while start+1 < end:
            mid = start + (end-start)/2
            if nums[mid] < target:
                start = mid
            else:
                end = mid
        if nums[start] == target:
            leftbd = start
        elif nums[end] == target:
            leftbd = end
        else:
            return [-1, -1]
        
        # find the righmost element
        start, end = leftbd, len(nums) - 1
        while start+1< end:
            mid = start + (end-start)/2
            if nums[mid] > target:
                end = mid
            else:
                start = mid
        if nums[end] == target:
            rightbd = end
        else:
            rightbd = start
        return [leftbd, rightbd]
        
