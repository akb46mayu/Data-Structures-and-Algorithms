"""
Numbers keep coming, return the median of numbers at every time a new number added.

Have you met this question in a real interview? Yes
Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. 
If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].


"""
# similar to leetcode 295 but outputs are a little bit different
from heapq import heappush, heappop
class Solution:
    """
    @param nums: A list of integers.
    @return: The median of numbers
    """
    def medianII(self, nums):
        # write your code here
        self.maxheap = []
        self.minheap = []
        result = []
        for num in nums:
            self.addHelper(num)
            val =  -self.maxheap[0]
            result.append(val)
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
