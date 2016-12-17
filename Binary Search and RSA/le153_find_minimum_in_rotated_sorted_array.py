class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        target = nums[-1]
        while start + 1 < end:
            mid = (start + end)/2
            if nums[mid] <= target:  # nums[mid]<target is also fine
                end = mid
            else:
                start = mid
        return min(nums[start], nums[end])
