"""
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
"""
# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head is None:
            return None
        
        hmap = {}
        p = head
        nhead = RandomListNode(head.label)
        q = nhead
        hmap[head] = nhead
        while p:
            q.random = p.random
            if p.next:
               q.next =  RandomListNode(p.next.label)
               hmap[p.next] = q.next
            else:
               q.next = None
            p = p.next
            q = q.next
          
        q = nhead
        while q:
            if q.random:
               q.random = hmap[q.random]
            q = q.next
        return nhead
        
