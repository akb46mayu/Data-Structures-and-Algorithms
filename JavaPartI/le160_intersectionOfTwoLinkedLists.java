/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cura = headA, curb = headB;
        int numchange = 0;
        while (numchange < 3) {
            if (cura != null && curb != null && cura.val == curb.val) {
                return cura;
            }
            if (cura == null) {
                cura = headB;
                numchange++;
            } else {
                cura = cura.next;
            }
            if (curb == null) {
                curb = headA;
                numchange++;
            } else {
                curb = curb.next;
            }
        }
        return null;
    }
}
