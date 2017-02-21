"""
Find K-th largest element in N arrays.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.


"""

from heapq import heappush, heappop
class Solution:
    # @param {int[][]} arrays a list of array
    # @param {int} k an integer
    # @return {int} an integer, K-th largest element in N arrays
    def KthInArrays(self, arrays, k):
        # Write your code here
        n = len(arrays)
        myheapq = []
        def push(i,j):
            if j < len(arrays[i]):
                heappush(myheapq, [-arrays[i][j], i, j])
        for i in range(n):
            arrays[i].sort(reverse = True)
            push(i, 0)
        while k >0 and myheapq:
            kthLargest, i, j = heappop(myheapq)
            push(i, j+1)
            if j > len(arrays[i]):
                push(i+1, 0)
            k -= 1
        return -kthLargest
