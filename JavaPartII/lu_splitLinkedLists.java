// subproblem of copy linkedlist 
// just split 1-> 2 -> 3 -> 4 as 1 -> 3 and 2 ->4 two lists separately

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    
}
public class MyClass {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        MyClass sol = new MyClass();
        
        ListNode res = sol.split2(n1);
        sol.printNodes(n1);
        sol.printNodes(res);
        
    }
    
    private void printNodes(ListNode cur) {
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        System.out.println("---------------");
    }
    
    private ListNode split(ListNode head) { //easier to remember, but a little bit longer
        ListNode res = head.next;
        ListNode p1 = head, p2 = res;
        while (p1.next.next != null) {
            ListNode p1next = p2.next;
            ListNode p2next = p2.next.next;
            p1.next = p1next;
            p2.next = p2next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return res;
    }
    
    private ListNode split2(ListNode head) { //not easier to remember, but shortger
        ListNode res = head.next;
        ListNode p1 = head;
        while (p1 != null) {
            ListNode p2 = p1.next;
            p1.next = p2.next;
            p1 = p1.next;
            if (p2.next != null) {
                p2.next = p1.next;
            }
        }
        return res;
    }
    
    
}
