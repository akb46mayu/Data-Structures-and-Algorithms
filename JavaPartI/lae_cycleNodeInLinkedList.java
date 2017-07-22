
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
  public ListNode cycleNode(ListNode head) {
    // write your solution here
    ListNode slow = head, fast = head;
    boolean cyc = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        cyc = true;
        break;
      }
    }
    if (!cyc) {
      return null;
    }
    ListNode two = head;
    while (two != slow) {
      slow = slow.next;
      two = two.next;
    }
    return two;
  }
}
