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
    if (head == null) {
      return temp;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy, next = cur.next;
    
    while(next != null) {
      if (value <= next.value) {
        temp.next = next;
        cur.next = temp;
        return dummy.next;
      }
      cur = next;
      next = cur.next;
    }
    cur.next = temp;
    return dummy.next;
  }
}
/////////////////////////////
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
