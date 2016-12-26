"""
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        mprev = self.findKthElement(dummy, m-1)
        mth = mprev.next
        nth = self.findKthElement(dummy, n)
        nnext = nth.next
        nth.next = None
        mthnew = self.reverseList(mth)
        mprev.next = mthnew
        mth.next = nnext
        return dummy.next
        
        
    def reverseList(self, head):
        prev = None
        while head:
            cur = head
            head = head.next
            cur.next = prev
            prev = cur
        return prev
    
    def findKthElement(self, head, k):
        # start from 0
        for i in  range(k):
            head = head.next
        return head
