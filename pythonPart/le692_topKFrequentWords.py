from heapq import heappush, heappop
class Element(object):  # seems like a minheap in count (when count are the same, larger alphabteic order has priority)
    def __init__(self, word, count):
        self.word = word
        self.count = count
    def __lt__(self, other):
        if self.count == other.count:
            return self.word > other.word
        return self.count < other.count
    def __eq__(self, other):
        return self.count == other.count and self.word == other.word
    
class Solution(object):
    def topKFrequent(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        wdict = collections.Counter(words)
        pq =  [] # minheap in count
        res = []
        i = 0
        for word, count in wdict.items():
            heappush(pq, (Element(word, count), word))
            if i >= k:
                heappop(pq)
            i += 1
        for i in range(len(pq)):
            res.append(heappop(pq)[1])
        res.reverse()   # can also use res[:,:,-1]
        return res
