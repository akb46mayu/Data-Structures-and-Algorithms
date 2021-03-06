"""
Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, 
and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Have you met this question in a real interview? Yes
Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.


"""
class Solution: # O(n)
    # @param A: Given an integer array
    # @return: void
    def heapify(self, A):
        # write your code here
        n = len(A)
        for i in range(n/2,-1,-1):
            self.heapifyHelper(A, i)
        
    def heapifyHelper(self, A, k):
        
        n = len(A)
        while k < n:  # smallest is the smallest value among Ak(father), son1 and son2
            smallest = k
            if 2*k + 1 < n and A[2*k+1] < A[smallest]:
                smallest = 2*k + 1
            if 2*k + 2 < n and A[2*k+2] < A[smallest]:
                smallest = 2*k + 2
            if smallest == k:
                break
            A[smallest], A[k] = A[k], A[smallest]
            
            k  = smallest
            
class Solution:  # n:number of points, T = O(nlogn)
    # @param A: Given an integer array
    # @return: void
    def heapify(self, A):
        # write your code here
        for i in range(len(A)):
            self.heapifyHelper(A, i)
        return A
    
    def heapifyHelper(self, A, k):
        while k:
            father = (k - 1)/2
            if A[k] < A[father]:
                A[k], A[father] = A[father], A[k]
                k = father
            else:
                break
