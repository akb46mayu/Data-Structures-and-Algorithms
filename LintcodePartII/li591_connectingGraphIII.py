"""

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(), Returns the number of connected component in the graph

Have you met this question in a real interview? Yes
Example
5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3

"""


class ConnectingGraph3:

    # @param {int} n
    def __init__(self, n):
        # initialize your data structure here.
        self.dict = {}
        for i in range(n):
            self.dict[i+1] = i+1
        self.out = n

    # @param {int} a, b
    # return nothing
    def connect(self, a, b):
        # Write your code here
        a = self.find(a)
        b = self.find(b)
        if a!= b:
            self.out -= 1    
            self.dict[a] = b
        
            
    # @param {int} a
    # return {int} the number of connected component
    # in the graph
    def query(self):
        # Write your code here
        return self.out
        
    def find(self, x):
        if self.dict[x] == x:
            return x
        self.dict[x] = self.find(self.dict[x])
        return self.dict[x]

