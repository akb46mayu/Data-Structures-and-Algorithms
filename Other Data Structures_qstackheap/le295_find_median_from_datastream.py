"""
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.
Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

"""
from heapq import heappush, heappop
class MedianFinder:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.minheap = []
        self.maxheap = []
        

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """
        if not self.minheap or num > self.minheap[0]:
            heappush(self.minheap, num)
            if len(self.minheap) > len(self.maxheap) + 1:
                heappush(self.maxheap, -heappop(self.minheap))
        else:
            heappush(self.maxheap, -num)
            if len(self.maxheap) > len(self.minheap):
                heappush(self.minheap, -heappop(self.maxheap))
                
    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        return (self.minheap[0] - self.maxheap[0])/2.0 if len(self.minheap)==len(self.maxheap) else self.minheap[0]

# Your MedianFinder object will be instantiated and called as such:
# mf = MedianFinder()
# mf.addNum(1)
# mf.findMedian()
