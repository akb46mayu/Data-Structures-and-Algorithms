/** (leet, lint)
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) { 
 *     this.value = value;
 *     next = null;
 *   }
 * }
**/ 

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i <= n; i++) {
      if (fast == null) {
        return head;
      }
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}
