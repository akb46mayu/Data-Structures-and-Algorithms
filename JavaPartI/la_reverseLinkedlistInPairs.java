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
public class Solution {  // recursion
  public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = reverseInPairs(head.next.next);
    newHead.next = head;
    return newHead;
  }
}


/////
public class Solution2 { //iteration
  public ListNode reverseInPairs(ListNode head) {
    // Write your solution here.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      ListNode temp = cur.next.next;
      cur.next.next = temp.next;
      temp.next = cur.next;
      cur.next = temp;
      cur = cur.next.next;
    }
    return dummy.next;
  }
}
