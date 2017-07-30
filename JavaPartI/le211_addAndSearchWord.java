/* Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/
/// trie + dfs + ascii array
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    TrieNode() {
        
    }
}
public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                TrieNode newnode = new TrieNode();
                cur.children[ch - 'a'] = newnode;
                cur = newnode;
            } else {
                cur = cur.children[ch - 'a'];
            }
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    private boolean find(String word, int level, TrieNode root) {
        if (level == word.length()) {
            return root.isWord;
        }
        char ch = word.charAt(level);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && find(word, level + 1, root.children[i])) {
                    return true;
                }
            }
            return false;
        } else if (root.children[ch - 'a'] != null) {
            return find(word, level + 1, root.children[ch - 'a']);
        } else {
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
