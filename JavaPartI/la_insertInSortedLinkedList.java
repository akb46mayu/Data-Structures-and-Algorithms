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
  public ListNode insert(ListNode head, int value) {
    // write your solution here
    ListNode temp = new ListNode(value);
    if (head == null || value <= head.value) {
      temp.next = head;
      return temp;
    }
    ListNode cur = head;
    while (cur!=null && cur.next!=null) {
      if (value> cur.value && value <= cur.next.value) {
        ListNode temp2 = cur.next;
        cur.next = temp;
        temp.next = temp2;
        return head;
      }
      cur = cur.next;
    }
    cur.next = temp;
    return head;
  }
}
