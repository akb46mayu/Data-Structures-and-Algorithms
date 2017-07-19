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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // write your solution here.
    if (l1 == null || l2 == null) {
      return l1 != null ? l1 : l2;
    }
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null || l2 != null || carry == 1) {
      int a = 0;
      int b = 0;
      if (l1 != null) {
        a = l1.value;
        l1 = l1.next;
      }
      if (l2 != null) {
        b = l2.value;
        l2 = l2.next;
      }
      int sum = (a + b + carry) % 10;
      carry = (a + b + carry) / 10;
      cur.next = new ListNode(sum);
      cur = cur.next;
    }
    return dummy.next;
  }
}
