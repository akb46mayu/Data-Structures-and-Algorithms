/* Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String endWord;
    TrieNode() {
        
    }
}
public class Solution {
    private TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        addWord(root, words);
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    
    private void addWord(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.next[ch - 'a'] != null) {
                    cur = cur.next[ch - 'a'];
                } else {
                    TrieNode newnode = new TrieNode();
                    cur.next[ch - 'a'] = newnode;
                    cur = newnode;
                }
            }
            cur.endWord = word;
        }
    }
    
    private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {
        char ch = board[i][j];
        if (board[i][j] == '*' || root.next[ch - 'a'] == null) {
            return;
        }
        int m = board.length, n = board[0].length;
        TrieNode rnext = root.next[ch - 'a'];
        if (rnext.endWord != null) {
            res.add(rnext.endWord);
            rnext.endWord = null;
        }
       
        board[i][j] = '*';
        if (i >= 1) {
            dfs(board, rnext, i - 1, j, res);
        }
        if (i < m - 1) {
            dfs(board, rnext, i + 1, j, res);
        }
        if (j  >= 1) {
            dfs(board, rnext, i, j - 1, res);
        }
        if (j  < n - 1) {
            dfs(board, rnext, i, j + 1, res);
        }
        board[i][j] = ch;
        
    }
}
