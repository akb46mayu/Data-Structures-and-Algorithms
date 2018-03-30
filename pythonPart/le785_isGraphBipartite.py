from collections import deque
class Solution(object):
    def isBipartite(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: bool
        """
        if graph is None:
            return True
        n = len(graph) 
        tag = [-1 for i in range(n)]
        for i in range(n):
            if tag[i] == -1:
                res = self.bipHelper(tag, i, graph)
                if res == False:
                    return False
        return True
        
    def bipHelper(self, tag, j, graph):
        q = deque() # int
        q.append(j)
        tag[j] = 0
        while q:
            cur = q.popleft() # idx, val
            m = len(graph[cur])
            if m == 0:
                return True
            curgp = tag[cur]
            for i in range(m):
                nbh = graph[cur][i]
                if tag[nbh] == -1:
                    q.append(nbh)
                    tag[nbh] = abs(1 - curgp)
                else:
                    if abs(1 - curgp) != tag[nbh]:
                        return False
        return True
        
