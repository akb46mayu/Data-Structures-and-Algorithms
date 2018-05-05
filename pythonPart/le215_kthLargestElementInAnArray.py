from heapq import heappush, heappop
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return nums
        pq = []
        for i in range(len(nums)):
            if i < k:
                heappush(pq, nums[i])
            else:
                if nums[i] > pq[0]:
                    heappop(pq)
                    heappush(pq, nums[i])
        return pq[0]
