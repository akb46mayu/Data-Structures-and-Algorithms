"""
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10

"""
class Solution:
    # @param {int[]} nums a mountain sequence which increase firstly and then decrease
    # @return {int} then mountain top
    def mountainSequence(self, nums):
        # Write your code here
        if not nums:
            return False
        n = len(nums)
        left, right = 0, n-1
        while left <= right:
            mid = left + (right - left)/2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and\ # this should be remembered
               (mid == n - 1 or nums[mid] > nums[mid+1]):
                return nums[mid]
            elif nums[mid] < nums[mid-1]:
                right = mid - 1
            elif nums[mid] < nums[mid+1]:
                left = mid + 1


class Solution:
    # @param {int[]} nums a mountain sequence which increase firstly and then decrease
    # @return {int} then mountain top
    def mountainSequence(self, nums):
        # Write your code here
        if not nums:
            return False
        n = len(nums)
        left, right = 0, n-1
        while left + 1 < right:
            mid = left + (right - left)/2
            if (mid == 0 and nums[mid] > nums[mid+1]) or\
               (mid == n - 1 and nums[mid] > nums[mid - 1]):
                return nums[mid]
            elif nums[mid] < nums[mid-1]:
                right = mid
            elif nums[mid] < nums[mid+1]:
                left = mid
            else:
                return nums[mid]
        if nums[left] > nums[right]:
            return nums[left]
        else:
            return nums[right]
