/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            ListNode temp = cur.next;
            if (temp != null && temp.val == val) {
                while (temp != null && temp.val == val) {
                    temp = temp.next;
                }
                cur.next = temp;
            }
            cur = temp;
        }
        return dummy.next;
    }
}
