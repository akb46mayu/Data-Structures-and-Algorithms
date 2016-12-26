"""
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if not lists:
            return []
        left, right = 0, len(lists) - 1
        while right > 0:
            if left >= right:
                left = 0
            else:
                lists[left] = self.mergeTwolists(lists[left], lists[right])
                left+= 1
                right-= 1
        return lists[0]
                
    
    def mergeTwolists(self, l1, l2):
        dummy = ListNode(0)
        cur = dummy
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        if l1:
            cur.next = l1
        if l2:
            cur.next = l2
        return dummy.next
