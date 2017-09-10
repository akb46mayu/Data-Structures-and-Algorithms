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
  public ListNode quickSort(ListNode head) {
    // write your solution here
    if (head == null) {
      return head;
    }
    ListNode midnode = findMid(head);
    ListNode d1 = new ListNode(0);
    ListNode d2 = new ListNode(0);
    // partition it in place, separte it into 3 components
    partition(head, midnode, d1, d2);
    d1.next = quickSort(d1.next);
    d2.next = quickSort(d2.next);
    if (d1.next == null) {
      d1.next = midnode;
    } else {
      ListNode tail1 = findTail(d1.next);
      tail1.next = midnode;
    }
    midnode.next = d2.next;
    return d1.next;
  }
  
  private ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      head = head.next;
    }
    return head;
  }
  
  private void partition(ListNode head, ListNode mid, ListNode d1, ListNode d2) {
    ListNode cur1 = d1, cur2 = d2;
    while (head != null) {
      if (head.value < mid.value) {
        cur1.next = head;
        cur1 = cur1.next;
      } else if (head.value > mid.value) {
        cur2.next = head;
        cur2 = cur2.next;
      }
      head = head.next;
    }
    cur1.next = null;
    cur2.next = null;
  }
  
  private ListNode findTail(ListNode head) {
    if (head == null) {
      return head;
    }
    while (head.next != null) {
      head = head.next;
    }
    return head;
  }
}
