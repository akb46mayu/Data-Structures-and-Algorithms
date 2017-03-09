"""
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.



"""
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])
        return max(self.robHelper(nums[0:n-1]), self.robHelper(nums[1:n]))
        
    
    def robHelper(self, nums):
        # by default it has at least 2 elements
        f = [0, 0]
        n = len(nums)
        f[1] = nums[0]
        for i in range(2, n+1):
            f[i%2] = max(f[(i-1)%2], nums[i-1] + f[(i-2)%2])
        return f[n%2]


class Solution2(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        return max(self.robHelper(nums[:n-1]),self.robHelper(nums[1:]))
        
    def robHelper(self, nums):     
        n = len(nums)
        f = [0]*n
        if n == 1:
            return nums[0]
        for i in range(n):
            if i == 1:
                f[i] = max(nums[i-1], nums[i])
            else:
                f[i] = max(nums[i]+f[i-2], f[i-1])
        return f[n-1]
