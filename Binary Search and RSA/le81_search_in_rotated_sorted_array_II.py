class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        n = len(nums)
        for i in xrange(n):
            if target == nums[i]:
                return True
        return False
