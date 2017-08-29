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
  public ListNode reorder(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next!= null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode d1 = head, d2 = slow.next;
    slow.next = null;
    // reverse
    d2 = reverse(d2);
    // 
    ListNode p1 = d1, p2 = d2, d3 = new ListNode(0);
    ListNode cur = d3;
    while (p1 != null && p2 != null) {
      cur.next = p1;
      cur = cur.next;
      p1 = p1.next;
      cur.next = p2;
      cur = cur.next; 
      p2 = p2.next;
    }
    if (p1 != null) {
      cur.next = p1;
    }
    return d3.next;
  }  
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newnode = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newnode;
  }
}
/// leetcode version (leet 143)

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p2 = slow.next;
        slow.next = null;
        p2 = reverse(p2);
        ListNode p1 = head;
        while (p1 != null && p2 != null) {
            ListNode p2next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = p2next;
        }
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
          return head;
        }
        ListNode cur = head, prev = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
