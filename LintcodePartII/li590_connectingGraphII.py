"""

Given n nodes in a graph labeled from 1 to n. 
There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(a), Returns the number of connected component nodes which include node a.

Have you met this question in a real interview? Yes
Example
5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3

"""

class ConnectingGraph2:

    # @param {int} n
    def __init__(self, n):
        # initialize your data structure here.
        self.dict = {}
        self.size = [1 for i in range(n+1)]
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
            self.size[b] += self.size[a]

    # @param {int} a
    # return {int}  the number of nodes connected component
    # which include a node.
    def query(self, a):
        # Write your code here
        a = self.find(a)
        return self.size[a]
        
    def find(self, x):
        if self.dict[x] == x:
            return x
        self.dict[x] = self.find(self.dict[x])
        return self.dict[x]
