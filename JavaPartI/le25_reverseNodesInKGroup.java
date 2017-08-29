/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy, prev = dummy;
        while (tail != null) {
            count = k;
            while (tail != null && count > 0) {
                tail = tail.next;
                count--;
            }
            if (tail == null) {
                return dummy.next;
            }
            head = prev.next;
            ListNode nextseg = tail.next;
            ListNode newtail = head;
            tail.next = null;
            prev.next = null;
            head = reverse(head);
            prev.next = head;
            newtail.next = nextseg;
            prev = newtail;
            tail = newtail;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null;      
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
