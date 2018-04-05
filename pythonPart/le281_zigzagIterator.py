# without using python iterator next or iter
class ZigzagIterator(object):
    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.count = 0
        self.i = 0
        self.j = 0
        self.v1 = v1
        self.v2 = v2
        self.single = False
        self.n1 = len(v1)
        self.n2 = len(v2)
        
    def next(self):
        """
        :rtype: int
        """
        if self.hasNext():
            out = 0
            if not self.single:
                if self.count % 2 == 0:
                    out = self.v1[self.i]
                    self.i += 1
                    self.count += 1
                else:
                    out = self.v2[self.j]
                    self.j += 1
                    self.count += 1
                
            else:
                if self.i < self.n1:
                    out = self.v1[self.i]
                    self.i += 1
                if self.j < self.n2:
                    out = self.v2[self.j]
                    self.j += 1
            return out 

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.i == self.n1 or self.j == self.n2:
            self.single = True
        return self.i != self.n1 or self.j != self.n2

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
