class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        minval = nums[0]
        for i in range(n):
            if nums[i] < minval:
                minval = nums[i]
        return minval


class Solution2(object):  # template...
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while start + 1 < end:
            mid = (start + end)/2
            if nums[mid] == nums[end]:
                end = end -1
            elif nums[mid] < nums[end]:
                end = mid
            else:
                start = mid       
        return min(nums[start], nums[end])
