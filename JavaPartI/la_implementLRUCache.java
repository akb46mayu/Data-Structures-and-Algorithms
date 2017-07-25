public class Solution<K, V> {
  static class Node<K, V> {
    K key;
    V val;
    Node<K, V> prev;
    Node<K, V> next;
    Node(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }
  private int limit;
  Node<K, V> head;
  Node<K, V> tail;
  Map<K, Node<K, V>> hmap;
  // limit is the max capacity of the cache
  public Solution(int limit) {
    this.limit = limit;
    this.hmap = new HashMap<K, Node<K, V>>();
  }
  
  public void set(K key, V value) {
    Node<K, V> node = null;
    if (hmap.containsKey(key)) {
      node = hmap.get(key);
      node.val = value;
      remove(node);
    } else if (hmap.size() < limit) {
      node = new Node<K, V>(key, value);
    } else {
      node = new Node<K, V>(key, value);
      remove(tail);
    }
    moveToHead(node);
  }
  
  public V get(K key) {
    Node<K, V> node = hmap.get(key);
    if (node != null) {
      remove(node);
      moveToHead(node);
      return node.val;
    } else {
      return null;
    }
  }
  
  private void moveToHead(Node<K, V> node) {
    // update hmap, move cur node to the head
    hmap.put(node.key, node);
    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
  
  private void remove(Node<K, V> node) {
    hmap.remove(node.key);
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == head) {
      head = head.next;
    }
    if (node == tail) {
      tail = tail.prev;
    }
    node.next = node.prev = null;
  }
}
