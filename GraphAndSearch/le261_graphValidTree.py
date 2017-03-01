"""
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Show Hint 
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
"""


class Solution(object):
    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        nodes = [i for i in range(n)]
        for e in edges:                 # will decide the cyclic case in a graph
            x1 = self.find(nodes, e[0])
            y1 = self.find(nodes, e[1])
            if x1 == y1:
                return False
            else:
                nodes[x1] = y1      
        return len(edges) == n - 1  # check whether it is separated (2 or 3 connected components)
        
       
    def find(self, nodes, x):
        if nodes[x] == x:
            return x
        return self.find(nodes, nodes[x])
