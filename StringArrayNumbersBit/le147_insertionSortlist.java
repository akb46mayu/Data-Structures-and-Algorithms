/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//


class Solution {/// way1
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head, prev = dummy;
        while (cur != null) {
            prev = dummy;
            while(prev.next != null && cur.val > prev.next.val) {
                prev = prev.next;
            }
            ListNode nextcur = cur.next;
            cur.next = prev.next;  //after this step , the node is disconected from the list
            prev.next = cur;
            cur = nextcur;
        }
        return dummy.next;
    }
}

//// way2
class Solution { // this solution has two lists, i just separte it as unsroted list and sorted list, quiet redundant.
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode i = dummy, cur = head;
        while (cur != null) {
            if (cur == head) {
                ListNode curnext = cur.next;
                cur.next = null;
                dummy.next = head;
                cur = curnext;
            } else {
                i = dummy;
                while(i.next != null && i.next.val < cur.val) {
                    i = i.next;
                }
                if (i.next == null) {
                    ListNode curnext = cur.next;
                    cur.next = null;
                    i.next = cur;
                    cur = curnext;
                } else {
                    ListNode inext = i.next;
                    ListNode curnext = cur.next;
                    cur.next = null;
                    i.next = cur;
                    cur = curnext;
                    i.next.next = inext;
                }
            }
        }
        return dummy.next;
    }
}


