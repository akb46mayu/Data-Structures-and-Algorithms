/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if (head == null) {
      return null;
    }
    Map<RandomListNode, RandomListNode> hmap = new HashMap<>();
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
    while (head != null) {
      if (!hmap.containsKey(head)) {
        hmap.put(head, new RandomListNode(head.value));
      }
      cur.next = hmap.get(head);
      if (head.random != null) {
        if (!hmap.containsKey(head.random)) {
          hmap.put(head.random, new RandomListNode(head.random.value));
        }
        cur.next.random = hmap.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
////  way 2 tiny differnet logic as follows:
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if (head == null) {
      return null;
    }
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
    Map<RandomListNode, RandomListNode> hmap = new HashMap<>();
    while (head != null) {
      if (!hmap.containsKey(head)) {
        hmap.put(head, new RandomListNode(head.value));
      }
      if (head.random != null && !hmap.containsKey(head.random)) {
        hmap.put(head.random, new RandomListNode(head.random.value));
      }
      cur.next = hmap.get(head);
      if (head.random != null) {
        cur.next.random = hmap.get(head.random);
      }
      cur = cur.next;
      head = head.next;
    }
    return dummy.next;
  }
}
// solution 2 leetcode version
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newnode = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = newnode;
            newnode.next = next;
            cur = next;
        }
        // random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                 cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // split
        return split(head);
    }
    
    private RandomListNode split(RandomListNode head) {
        RandomListNode res = head.next;
        RandomListNode p1 = head;
        while (p1 != null) {
            RandomListNode p2 = p1.next;
            p1.next = p2.next;
            p1 = p1.next;
            if (p2.next != null) {
                p2.next = p1.next;
            }
        }
        return res;
    }
}


// leetcode version 2 (split stopping criteria is diff)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newnode = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = newnode;
            newnode.next = next;
            cur = next;
        }
        // random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                 cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // split
        return split(head);
    }
    
    private RandomListNode split(RandomListNode head) {
        RandomListNode res = head.next;
        RandomListNode p1 = head, p2 = res;
        while (p1.next.next != null) {
            RandomListNode p1next = p2.next;
            RandomListNode p2next = p2.next.next;
            p1.next = p1next;
            p2.next = p2next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return res;
    }
}
