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

public class Solution {  //different logic
  public ListNode insert(ListNode head, int value) {
    // write your solution here
    ListNode temp = new ListNode(value);
    if (head == null || value <= head.value) {
      temp.next = head;
      return temp;
    }
    ListNode prev = head, cur = head.next;
    
    while (prev.next != null) {
      if (temp.value <= cur.value) {
        prev.next = temp;
        temp.next = cur;
        return head;
      }
      prev = prev.next;
      cur = cur.next;
    }
    
    if (temp.value > prev.value) {
      prev.next = temp;
    }
    return head;
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
