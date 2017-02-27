"""

Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

 Notice

Each connected component should sort by label.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

"""


# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []
class Solution:
    # @param {UndirectedGraphNode[]} nodes a array of undirected graph node
    # @return {int[][]} a connected set of a undirected graph
    def connectedSet(self, nodes):
        # Write your code here
        self.v = {}
        for node in nodes:
            self.v[node.label] = False
        res = []
        for node in nodes:
            if not self.v[node.label]:
                tmp = []
                self.dfs(node, tmp)
                res.append(sorted(tmp))
        return res
        
    def dfs(self, x, tmp):
        self.v[x.label] = True
        tmp.append(x.label)
        for nd in x.neighbors:
            if not self.v[nd.label]:
                self.dfs(nd, tmp)
