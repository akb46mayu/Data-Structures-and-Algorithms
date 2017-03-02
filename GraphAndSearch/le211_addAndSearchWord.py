"""

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A 
. means it can represent any one letter.

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

"""

class TrieNode:
    def __init__(self):
        self.childs = {}
        self.isWord = False

class WordDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.root
        for letter in word:
            child = node.childs.get(letter)
            if not child:
                child = TrieNode()
                node.childs[letter] = child
            node = child
        node.isWord = True


    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        return self.searchHelper(self.root, 0, word)
        
    def searchHelper(self, cur,  start, word):
        if len(word) == start:
            return cur.isWord
        if word[start] in cur.childs: 
            return self.searchHelper(cur.childs[word[start]], start+1, word)
        elif word[start] == '.':
            for c in cur.childs:
                if self.searchHelper(cur.childs[c], start+1, word):
                   return True
        return False

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
