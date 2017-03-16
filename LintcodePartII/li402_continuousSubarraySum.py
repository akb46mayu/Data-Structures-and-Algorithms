"""
Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [-3, 1, 3, -3, 4], return [1,4].


"""

class Solution:
    # @param {int[]} A an integer array
    # @return {int[]}  A list of integers includes the index of the 
    #                  first number and the index of the last number
    def continuousSubarraySum(self, A):
        # Write your code here  
        if not A:
            return [-1, -1]
        n = len(A)
        maxsum = -sys.maxint
        prevsum = 0
        slocal, elocal = 0, 0
        sglobal, eglobal = 1, 1
        for i in range(n):
            cursum = prevsum + A[i]
            
            if cursum < 0 or (cursum > 0 and prevsum <= 0):
                cursum = A[i]
                prevsum = cursum
                slocal, elocal = i, i
            elif cursum > 0 and prevsum > 0:
                prevsum = cursum
                elocal = i
            
            if cursum > maxsum:
                maxsum = cursum
                sglobal, eglobal = slocal, elocal
            
        return [sglobal, eglobal]

    
class Solution2:
    # @param {int[]} A an integer array
    # @return {int[]}  A list of integers includes the index of the 
    #                  first number and the index of the last number
    def continuousSubarraySum(self, A):
        # Write your code here
        if not A:
            return [-1, -1]
        sum = 0
        start, end = 0, -1
        maxsum = -sys.maxint
        for x in A:
            if sum < 0:
                sum = x
                start = end + 1
                end = start
            else:
                sum += x
                end += 1
            if sum > maxsum:
                maxsum = sum
                result = [start, end]
        return result
