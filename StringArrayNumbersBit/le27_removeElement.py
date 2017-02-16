"""
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.


"""

class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = 0
        while i<=len(nums)-1:
            if val == nums[i]:
                del(nums[i])
            else:
                i += 1    
        return len(nums)

class Solution2(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i, end = 0, len(nums)-1
        while i <= end:
        
            if val == nums[i]:
                nums[i], nums[end] = nums[end], nums[i]
                end -= 1
            else:
                i += 1
        return end+1
