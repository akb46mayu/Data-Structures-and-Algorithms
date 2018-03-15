# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
  def middleNode(self, head):
    """
    input: ListNode head
    return: ListNode
    """
    # write your solution here
    if head == None:
      return head
    slow = head
    fast = head
    while fast.next != None and fast.next.next != None:
      fast = fast.next.next
      slow = slow.next
    return slow
