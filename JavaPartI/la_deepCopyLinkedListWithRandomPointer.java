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
        while (head!= null) {
            RandomListNode nextold = head.next;
            RandomListNode temp = new RandomListNode(head.label);
            head.next = temp;
            temp.next = nextold;
            head = nextold;
        }
        RandomListNode slow = cur;
        while (slow != null) {
            if (slow.random != null) {
              slow.next.random = slow.random.next;
          	}
            slow = slow.next.next;
        }
        return splitList(cur);
    }
    
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newnode = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = head.next;
            } 
        }
        return newnode;
    }
}
