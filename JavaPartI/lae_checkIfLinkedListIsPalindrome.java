
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
//// see leet 234
public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    // Write your solution here.
    ListNode mid = findMid(head);
    ListNode rHalfHead = reverse(mid.next);
    mid.next = null;
    boolean res = isEqual(head, rHalfHead);
    mid.next = reverse(rHalfHead);
    return res;
  }
  private boolean isEqual(ListNode p1, ListNode p2) {
    ListNode one = p1, two = p2;
    while (one != null && two != null) {
      if (one.value != two.value) {
        return false;
      }
      one = one.next;
      two = two.next;
    }
    return true;
  }
  
  private ListNode findMid(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newhead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newhead;
  }

}
