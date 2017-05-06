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
  public int numberOfNodes(ListNode head) {
    // Write your solution here.
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}
