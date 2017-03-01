"""

Given an interval list which are flying and landing time of the flight. 
How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3

"""

"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    # @param airplanes, a list of Interval
    # @return an integer
    def sorter(self, x, y):
        if x[0] != y[0]:
            return x[0] - y[0]
        return x[1] - y[1] 
    def countOfAirplanes(self, airplanes):
        # write your code here
        airpoints = []
        temp = 0
        out = 0
        for plane in airplanes:
            airpoints.append((plane.start, 1))
            airpoints.append((plane.end, -1))
        airpoints = sorted(airpoints, cmp = self.sorter)
        for i, delta in airpoints:
            temp += delta 
            out = max(out, temp)
            
        return out
