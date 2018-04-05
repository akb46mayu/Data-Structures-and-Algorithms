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
        cur = head  # this is more clear  (head can also be used as the cur pointer)
        prev = None
        while cur!= None:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev

    
class Solution2(object):
  def reverse(self, head):
    """
    input: ListNode head
    return: ListNode
    """
    # write your solution here

    if head is None or head.next is None:
      return head
    
    temp = self.reverse(head.next)
    head.next.next = head
    head.next = None
    return temp
