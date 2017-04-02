/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode middleNode(ListNode head) {
    // write your solution here
    ListNode slow = head, fast = head;
    if (head == null) {
      return head;
    }
    while ( fast.next!= null && fast.next.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
