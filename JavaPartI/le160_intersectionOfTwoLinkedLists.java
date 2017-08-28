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
        if (headA == null || headB == null) {
            return null;
        }
        ListNode one = headA, two = headB;
        int count = 0;
        while (count < 3) {
            if (one != null && two != null && one == two) { // one.val == two.val also work
                return one;
            }
            if (one == null) {
                one = headB;
                count++;
            } else {
                one = one.next;
            }
            
            if (two == null) {
                two = headA;
                count++;
            } else {
                two = two.next;
            }
            
        }
        return null;
    }
}
/// use the length of the lists

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode one = headA, two = headB;
        int lena = countLen(headA), lenb = countLen(headB);
        while (lena < lenb) {
            two = two.next;
            lenb--;
        }
        while (lena > lenb) {
            one = one.next;
            lena--;
        }
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
    
    private int countLen(ListNode head) { // count the number of nodes
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
}
