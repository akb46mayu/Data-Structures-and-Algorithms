/**
 * Definition for ListNode
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
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        // assume you have to do rehash without juding the current state.
        int cap = 2 * hashTable.length;
        ListNode[] newtable = new ListNode[cap];
        for (ListNode node : hashTable) {
            while (node != null) {
                int idx = hashcode(node.val, cap);
                if (newtable[idx] == null) {
                    newtable[idx] = new ListNode(node.val);
                } else {
                    ListNode cur = newtable[idx];
                    while (cur.next != null) {
                       cur = cur.next;
                    }
                    cur.next = new ListNode(node.val);
                }           
                node = node.next;
            }
        }
        return newtable;
    }
    
    private int hashcode(int key, int cap) {
            return (key % cap + cap) % cap;
    }
};
