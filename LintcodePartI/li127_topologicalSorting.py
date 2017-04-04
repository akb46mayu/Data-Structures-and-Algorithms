
# Definition for a Directed graph node
# class DirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class MyQueue:
    
    def __init__(self):
        self.item = []
    def enqueue(self, x):
        self.item.insert(0,x)
    def dequeue(self):
        return self.item.pop()
    def empty(self):
        return len(self.item) == 0
    def size(self):
        return len(self.item)
        
        
class Solution:  # TLE problem, I suggest to use a personal implemented queue class
    """
    @param graph: A list of Directed graph node
    @return: A list of graph nodes in topological order.
    """
    def topSort(self, graph):
        # write your code here
        hash = {}
        q = MyQueue()
        result = []
        for nd in graph:
            for x in nd.neighbors:
                if x not in hash.keys():
                    hash[x] = 1
                else:
                    hash[x] += 1

        for nd in graph:
            if nd not in hash.keys():
                q.enqueue(nd)
                result.append(nd)
        
        while not q.empty():
            head = q.dequeue()
            for nbh in head.neighbors:
                hash[nbh] -= 1
                if hash[nbh] == 0:
                    q.enqueue(nbh)
                    result.append(nbh)
                
        return result
    
    
import Queue
class Solution2:  # this also has TLE problem
    """
    @param graph: A list of Directed graph node
    @return: A list of graph nodes in topological order.
    """
    def topSort(self, graph):
        # write your code here
        hash = {}
        q = Queue.Queue(maxsize = len(graph))
        result = []
        for nd in graph:
            for x in nd.neighbors:
                if x not in hash.keys():
                    hash[x] = 1
                else:
                    hash[x] += 1

        for nd in graph:
            if nd not in hash.keys():
                q.put(nd)
                result.append(nd)
        
        while not q.empty():
            head = q.get()
            for nbh in head.neighbors:
                hash[nbh] -= 1
                if hash[nbh] == 0:
                    q.put(nbh)
                    result.append(nbh)
                
        return result
