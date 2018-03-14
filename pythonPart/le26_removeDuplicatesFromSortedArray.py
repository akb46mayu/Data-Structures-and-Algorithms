class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 1
        
        j = 0 # inclusive 
        n = len(nums)
        for i in range(1, n):
            if nums[i] != nums[j]:
                j += 1
                nums[i], nums[j] = nums[j], nums[i]
        return j + 1
