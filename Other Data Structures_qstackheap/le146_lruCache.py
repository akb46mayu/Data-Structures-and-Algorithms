"""
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
"""
class listNode(object):
    def __init__(self, key = None, val = None, next = None):
        self.key = key
        self.val = val
        self.next = next

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cap = capacity
        self.head = listNode()
        self.tail = self.head
        self.hash = {}
        
    def pushBack(self, node):
        self.tail.next = node
        self.hash[node.key] = self.tail
        self.tail = node
        
    def popFront(self):
        if not self.head.next:  # This can be omitted
            return
        del self.hash[self.head.next.key]
        self.head.next = self.head.next.next
        self.hash[self.head.next.key] = self.head
        
    def kick(self, prev): # move prev.next to the back
        node = prev.next
        if node == self.tail:
            return
        prev.next = node.next
        if node.next is not None:
            self.hash[node.next.key] = prev
        self.pushBack(node)
    
    def get(self, key):
        """
        :rtype: int
        """
        if key in self.hash:
            self.kick(self.hash[key])
            return self.hash[key].next.val
        return -1
        
    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key not in self.hash:
            self.pushBack(listNode(key,value,None))
            if len(self.hash) > self.cap:
                 self.popFront()
        else:
            self.kick(self.hash[key])
            self.hash[key].next.val = value
