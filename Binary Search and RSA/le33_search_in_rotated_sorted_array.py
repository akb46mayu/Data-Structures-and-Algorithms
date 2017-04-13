class Solution(object):   # can also use the classical binary search without post processing, see java
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while start + 1 < end:
            mid = (start + end)/2
            if nums[mid] == target:
                return mid
            elif nums[mid] > nums[start]:
                if nums[mid] >= target and target >= nums[start]:
                    end = mid
                else:
                    start = mid
            else:
                if nums[mid] <= target and target <= nums[end]:
                    start = mid
                else:
                    end = mid
        if nums[start] == target:
            return start
        elif nums[end] == target:
            return end
        else:
            return -1
