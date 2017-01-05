"""
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.


"""
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        if n == 0:
            return []
        out = []
        count1, count2 = 0, 0
        cand1, cand2 = None, None
        for x in nums:
            if cand1 == x:   # you can not put count1==0 at the beggining
                count1 += 1
            elif cand2 == x:
                count2 += 1
            elif count1 == 0:
                cand1 = x
                count1 += 1
            elif count2 == 0:
                cand2 = x
                count2 += 1
           
            else:
                count1 -= 1
                count2 -= 1
                
        count1, count2 = 0, 0
        for x in nums:
            if x == cand1:
                count1 += 1
            elif x == cand2:
                count2 += 1
            else:
                continue
        if count1 > n/3:
            out.append(cand1)
        if count2 > n/3:
            out.append(cand2)
        return out
            
