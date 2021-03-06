"""
Find the number Weak Connected Component in the directed graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
Notice
Sort the element in the set in increasing order
Have you met this question in a real interview? Yes
Example
Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
"""
# main idea is to use union-find
# Definition for a directed graph node
# class DirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

# f is a hash set which saves the nearest node label the current node will point to (not has to be the cur node's father)
class Solution:
    # @param {DirectedGraphNode[]} nodes a array of directed graph node
    # @return {int[][]} a connected set of a directed graph

        

    def connectedSet2(self, nodes):
        # Write your code here
        self.f = {}
        for node in nodes:
            self.f[node.label] = node.label
        for node in nodes:
            for nb in node.neighbors:
                self.merge(node.label, nb.label)
        g = {} # reflects each connected component's father
        res = []
        cnt = 0  # idx of the result
        for node in nodes:
            x = self.find(node.label)
            if not x in g.keys():
                cnt += 1
                g[x] = cnt
                res.append([])
            res[g[x]-1].append(node.label) 
        return res
        
    def find(self, x):
        if self.f[x] == x:
            return x
        self.f[x] = self.find(self.f[x])
        return self.f[x]
    
    def merge(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x!= y:
            self.f[x] = y
