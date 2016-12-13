class Solution:
    # @param nums: The integer array
    # @param target: Target number to find
    # @return the first position of target in nums, position start from 0 
    def binarySearch(self, nums, target):
        # write your code here
        
        start = 0
        end = len(nums) -1 
        while start + 1 <  end:
            mid = (start + end)/2
            if nums[mid] < target:
                start = mid 
            else:
                end = mid 
           
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        return -1
