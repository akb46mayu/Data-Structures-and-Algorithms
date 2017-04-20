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
  public ListNode merge(ListNode one, ListNode two) {
    // write your solution here  (do not need to decide one, two whether are null at the same time , because the code does it at the end)
    ListNode dummy = new ListNode(0);   
    ListNode cur = dummy;
    while (one!=null && two != null) {
      if (one.value <= two.value) {
         cur.next = one;
         one = one.next;
      } else {
         cur.next = two;
         two = two.next;
      }
      cur = cur.next;
    }
    if (one!=null) {
      cur.next = one;
    } else {
      cur.next = two;
    }
    return dummy.next;
  }
}
