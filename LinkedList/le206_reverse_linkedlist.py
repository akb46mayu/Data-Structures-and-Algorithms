"""
Reverse a singly linked list.
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

    
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        cur = head  # this is more clear 
        prev = None
        while cur!= None:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev
