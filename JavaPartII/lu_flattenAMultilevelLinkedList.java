import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode flatten(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode p1 = res;
        if (head == null) {
            return res.next;
        }
        Queue<ListNode> q = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            q.offer(cur);
            cur = cur.next;
        }
        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            p1.next = temp;
            p1 = p1.next;
            if (temp.child != null) {
                cur = temp.child;
                while (cur != null) {
                    q.offer(cur);
                    cur = cur.next;
                }
            }
        }
        return res.next;
    }
    
    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n2.child = n5;
        n3.child = n6;
        n6.next = n7;
        n7.child = n8;
        
        Solution sol = new Solution();
        ListNode res = sol.flatten(n1);
        ListNode cur = res;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
