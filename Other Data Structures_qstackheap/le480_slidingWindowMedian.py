"""

Median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.


"""
# using bisect and insort
import bisect
class Solution(object):
    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        window, out, result = [], [], []
        for i in range(len(nums)):
            if i >= k:
                window.remove(nums[i-k])
            bisect.insort(window, nums[i])
            if i >= k-1:
                out = float(window[k/2-1] + window[k/2])/2.0 if  k%2 == 0  else float(window[k/2])
                result.append(out)
        return result
       
# lazy removal approach (assume maxheap size <= minheap size)
from heapq import heappush, heappop
import collections
class Solution2(object):
    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        maxheap = []
        minheap = []
        hashes = collections.defaultdict(int)
        result = []
        
        for i in range(k):
            heappush(minheap, nums[i])
        for _ in range(k/2, 0, -1):
            heappush(maxheap, -heappop(minheap))
            
        #for i in range(k, len(nums)+1):
        i = k
        while True:
         
            if k%2: 
                medval = float(minheap[0])
            else:
                medval = float(minheap[0] - maxheap[0])/2.0
            result.append(medval)
            
            if i == len(nums):
                break
            
            rmv = nums[i-k]
            addv = nums[i]
            balance = 0
   
            i += 1
            
            # point removal for top case
            if rmv >= minheap[0]:
                balance -= 1
                if rmv == minheap[0]:
                    heappop(minheap)
                else:
                    hashes[rmv] += 1
            else:
                balance += 1
                if rmv == -maxheap[0]:
                    heappop(maxheap)
                else:
                    hashes[rmv] += 1

            # point addition
            if minheap and addv >= minheap[0]:
                balance += 1
                heappush(minheap, addv)
            else:
                balance -= 1
                heappush(maxheap, -addv)

            # balance case
            if balance < 0:
                heappush(minheap, -heappop(maxheap))
            elif balance > 0:
                heappush(maxheap, -heappop(minheap))
            # hashes:
            while minheap and hashes[minheap[0]]:
                hashes[heappop(minheap)] -= 1
            while maxheap and hashes[-maxheap[0]]:
                hashes[-heappop(maxheap)] -= 1
        
        return result  



## old solution TLE problem
from heapq import heappush, heappop, heapify
class Solution3(object):
    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        self.maxheap = []
        self.minheap = []
        result = []
        if len(nums) < k:
            return result
        for i in range(len(nums)):
            if i <= k-1:
                self.addHelper(nums[i])
                if i == k-1:
                    out = float(self.minheap[0] - self.maxheap[0])/2.0 \
                          if len(self.minheap) == len(self.maxheap) else float(-self.maxheap[0])
                    result.append(out)
            else:
                self.addHelper(nums[i])
                self.delHelper(nums[i-k])
                out = float(self.minheap[0] - self.maxheap[0])/2.0 \
                          if len(self.minheap) == len(self.maxheap) else float(-self.maxheap[0])
                result.append(out)
                
                
        return result

    def addHelper(self, num):
        if not self.maxheap or num < -self.maxheap[0]:
            heappush(self.maxheap, -num)
            n1, n2 = len(self.maxheap), len(self.minheap)
            if n1 > n2 + 1:
                heappush(self.minheap, -heappop(self.maxheap))
        else:
            heappush(self.minheap, num)
            n1, n2 = len(self.maxheap), len(self.minheap)
            if n1 < n2:
                heappush(self.maxheap, -heappop(self.minheap))
                
    def delHelper(self, num):
        delidx = -1
        if  num <= -self.maxheap[0]:
            for i in range(len(self.maxheap)):
                if -self.maxheap[i] == num:
                    delidx = i
                    break
            self.maxheap[delidx] = self.maxheap[-1]
            self.maxheap.pop()
            heapify(self.maxheap)
            if len(self.maxheap) < len(self.minheap):
                heappush(self.maxheap, -heappop(self.minheap))
        else:
            for i in range(len(self.minheap)):
                if self.minheap[i] == num:
                    delidx = i
                    break
            self.minheap[delidx] = self.minheap[-1]
            self.minheap.pop()
            heapify(self.minheap)
            if len(self.minheap) + 1 < len(self.maxheap):
                heappush(self.minheap, -heappop(self.maxheap))
