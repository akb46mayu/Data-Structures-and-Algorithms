import java.util.*;
class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class Main {
  public ListNode selectionSort(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    ListNode prev = dummy;
    ListNode tarprev;
    while (cur != null ) {
      tarprev = findMin(prev, cur);
      swap(prev, tarprev);
      prev = prev.next;
      cur = prev.next;
    }
    return dummy.next;
  }
  
  private ListNode findMin(ListNode headprev, ListNode head) {
    // return min pos's previous node, org input should not be changed
    ListNode prev = headprev;
    ListNode cur = head;
    ListNode minprev = headprev;
    int minval = cur.value;
    while (cur != null) {
      if (cur.value < minval) {
        minval = cur.value;
        minprev = prev;
      }
      prev = prev.next;
      cur = cur.next;
    }
    return minprev;
  }
  
  private void swap(ListNode aprev, ListNode bprev) {
    if (aprev == bprev) {
      return;
    }
    ListNode a = aprev.next, b = bprev.next;
    if (a == bprev) {  //  a, b are adjacent to each other
      ListNode bnext = b.next;
      a.next = bnext;
      b.next = a;
      aprev.next = b;
      //bprev = aprev.next; // update seems useless
    } else { // a and b has one node
      ListNode bnext = b.next;
      ListNode anext = a.next;
      a.next = bnext;
      bprev.next = a;
      b.next = anext;
      bprev = a;
      aprev.next = b;
    }
  }
  public static void main(String[] args) {
    Main sol = new Main();
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(5);
    
    //ListNode n0 = new ListNode(-100);
    //n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    //ListNode newhead = n3;
    //sol.swap(n1,n3);
    //ListNode res = sol.swap2(n1, n1, n3);
    //ListNode res = sol.findMin(n2, n3);
   // System.out.println(res.value);
     
    ListNode res = sol.selectionSort(n1);
    ListNode cur = res;
    while (cur != null) {
      System.out.println(cur.value);
      cur = cur.next;
    }
    System.out.println("----------");
  }
}
