// hashmap version
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); 
    boolean isWord;
    TrieNode() {

    }   
}
public class Trie {
    private TrieNode root; 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            } else {
                TrieNode newnode = new TrieNode();
                cur.children.put(ch, newnode);
                cur = newnode;
            }
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            } else {
                return false;
            }
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
