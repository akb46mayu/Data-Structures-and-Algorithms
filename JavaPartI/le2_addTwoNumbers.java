/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        int x, y;
        while(one != null || two != null || carry == 1) {
            x = 0;
            y = 0;
            if (one != null) {
                x = one.val;
                one = one.next;
            }
            if (two != null) {
                y = two.val;
                two = two.next;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return res.next;
    }
}
