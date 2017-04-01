/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean cycleTag = false;
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleTag = true;
                break;
            }
        }
        if (cycleTag == true) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;  
            }
            return fast;
        } else {
            return null;
        }
        
    }
}
