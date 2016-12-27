"""
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
"""

# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    # q: use this to implement BFS, pop order does not matter (like a stack in fact)
    # cloned: a hash map(dict) which records the mapping btw old and new nodes; prevent copying the same nodes
    # when copying the neighbors of a node, remember it should copy the new nodes as the nbs not the old ones
    def cloneGraph(self, node):
        if node is None:
            return None
        
        clonedNode = UndirectedGraphNode(node.label)
        cloned = {node:clonedNode}
        q = [node]
        while q:
            cur = q.pop()
            for nbh in cur.neighbors:
                if nbh not in cloned:
                     cloned[nbh] = UndirectedGraphNode(nbh.label)
                     q.append(nbh)
                cloned[cur].neighbors.append(cloned[nbh])
        return cloned[node]
