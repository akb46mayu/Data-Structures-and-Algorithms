"""

Given an circular integer array (the next element of the last element is the first element), 
find a continuous subarray in it, where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number.

If duplicate answers exist, return any of them.

Have you met this question in a real interview? Yes
Example
Give [3, 1, -100, -3, 4], return [4,1].

"""

class Solution: # simpler solution
    # @param {int[]} A an integer array
    # @return {int[]}  A list of integers includes the index of the 
    #                  first number and the index of the last number
    def continuousSubarraySumII(self, A):
        # Write your code here
        if not A:
            return [-1, -1]
        n = len(A)
        sumAll = 0
        
        # compute the maximum value alone the ragne
        sumMax = -sys.maxint
        sumprev = 0
        start, end = 0, -1
        for x in A:
            sumAll += x
            if sumprev > 0:
                sumprev += x
                end += 1
            else:
                sumprev = x
                start = end + 1
                end = start
            if sumprev > sumMax:
                sumMax = sumprev
                result = [start, end]


        # compute the minimum value in the range:
        
        sumprev = 0
        start, end = 0, -1
        for x in A:

            if sumprev < 0:
                sumprev += x
                end += 1
            else:
                sumprev = x
                start = end + 1
                end = start
            if start == 0 and end == n-1:
                continue
            if sumAll - sumprev > sumMax:
                sumMax = sumAll - sumprev
                result = [(end + 1)%n, (start-1+n)%n]
       
        return result

class Solution2:
    # @param {int[]} A an integer array
    # @return {int[]}  A list of integers includes the index of the 
    #                  first number and the index of the last number
    def continuousSubarraySumII(self, A):
        # Write your code here
        if not A:
            return [-1, -1]
        n = len(A)
        sumAll = 0
        for x in A:
            sumAll += x
        
        # compute the minimum value in the range:
        sumMin = sys.maxint
        sumprev = 0
        start, end = 0, -1
        for x in A:
            if sumprev < 0:
                sumprev += x
                end += 1
            else:
                sumprev = x
                start = end + 1
                end = start
            if sumprev < sumMin:
                sumMin = sumprev
                start1, end1 = start, end
       
        # compute the maximum value alone the ragne
        sumMax = -sys.maxint
        sumprev = 0
        start, end = 0, -1
        for x in A:
            if sumprev > 0:
                sumprev += x
                end += 1
            else:
                sumprev = x
                start = end + 1
                end = start
            if sumprev > sumMax:
                sumMax = sumprev
                start2, end2 = start, end
        
        if sumAll - sumMin <= sumMax:
            return [start2, end2]
            
        else:
           if start1 == 0 and end1 != n-1:
               return [end1+1, n-1]
           elif start1 != 0 and end1 == n -1:
               return [0, start1-1]
           elif start1 == 0 and end1 == n - 1:
               return [start2, end2]
           else:
               return [end1+1, start1-1]
