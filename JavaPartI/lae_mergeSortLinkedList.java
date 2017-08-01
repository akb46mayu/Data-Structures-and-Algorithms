
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
  public ListNode mergeSort(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    ListNode newhead = mid.next;
    mid.next = null;
    return mergeLists(mergeSort(head), mergeSort(newhead));
  }
  

  private ListNode mergeLists(ListNode one, ListNode two) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (one != null && two != null) {
      if (one.value < two.value) {
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    if (one != null) {
      cur.next = one;
    }
    if (two != null) {  // why we have to keep this?
      cur.next = two;
    }
    return dummy.next;
  }
  
  private ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
