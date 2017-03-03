"""
Given n nodes in a graph labeled from 1 to n. 
There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

Have you met this question in a real interview? Yes
Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
"""


class ConnectingGraph:

    # @param {int} n
    def __init__(self, n):
        # initialize your data structure here.
        self.dict = {}
        for i in range(n):
            self.dict[i+1] = i+1
        
   
    # @param {int} a, b
    # return nothing
    def connect(self, a, b):
        # Write your code here
        a = self.find(a)
        b = self.find(b)
        if a!= b:
           self.dict[a] = b
        

    # @param {int} a, b
    # return {boolean} true if they are connected or false
    def query(self, a, b):
        # Write your code here
        
        a = self.find(a)
        b = self.find(b)
        return a == b
    
    def find(self, x):
        if self.dict[x] == x:
            return x
        self.dict[x] = self.find(self.dict[x])
        return self.dict[x]
