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
  public ListNode partition(ListNode head, int target) {
    // write your solution here
    if (head == null || head.next == null) {  // this can also be omitted
      return head;
    }
    ListNode dummysmall = new ListNode(0);
    ListNode dummylarge = new ListNode(0);
    
    ListNode curs = dummysmall, curl = dummylarge;
    while (head!=null) {
      if (head.value < target) {
        curs.next = head;
        curs = curs.next;
      } else {
        curl.next = head;
        curl = curl.next;
      }
      head = head.next;
    }
    curs.next = dummylarge.next;
    curl.next = null;
    return dummysmall.next;
  }
}
