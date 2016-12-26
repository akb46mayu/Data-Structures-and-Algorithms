"""
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
                    return 
                
        fast = slow = head
        while fast.next and fast.next.next: # find the middle node and sperate input into two lists (1st list's len is >= 2nd list)
            fast = fast.next.next
            slow = slow.next
        head2 = slow.next
        slow.next = None
        
        prev = None  #reverse linked list pointed by head2
        while head2:
            cur = head2
            head2 = head2.next
            cur.next = prev
            prev = cur
        head2 = prev
        
        h1, h2 = head, head2 # combine the two lists (template should be remembered)
        while h2:
            tmp1, tmp2 = h1.next, h2.next
            h1.next = h2
            h2.next = tmp1
            h1 = tmp1
            h2 = tmp2
