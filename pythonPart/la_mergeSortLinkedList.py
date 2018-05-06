# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
  def mergeSort(self, head):
    """
    input: ListNode head
    return: ListNode
    """
    # write your solution here
    
    if head is None or head.next is None:
      return head
    mid = self.findMid(head)
    newhead = mid.next
    mid.next = None
    left = self.mergeSort(head)
    right = self.mergeSort(newhead)
    
    return self.mergeList(left, right)
    
  def findMid(self, head):
      slow = head
      fast = head
      while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
      return slow
        
    
  def mergeList(self, head1, head2):
    a = head1
    b = head2
    d = ListNode(0)
    c = d
    while a and b:
      if a.val < b.val:
        c.next = a
        c = c.next
        a = a.next
      else:
        c.next = b
        c = c.next
        b = b.next
    if a:
      c.next = a
    if b:
      c.next = b
    return d.next
