## given sorted array, with one missing number, the first element is not missing.
# use logn time to implement it



class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x = nums[0]
        y = x + 1
        n = len(nums)
        i, j = 0, n - 1
        while i  < j:
            m = i + (j - i) // 2
            if nums[m] - m == y:
                if m != 0 and nums[m - 1] - (m - 1) == x:
                    return nums[m] - 1
                else:
                    j = m - 1
            else:
                i = m + 1

        return nums[i] - 1
        
sol = Solution()
nums = [1, 3, 4, 5, 6]
a = sol.missingNumber(nums)
print (a)
