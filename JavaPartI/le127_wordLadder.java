/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

*/
/// bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }
        Queue<String> q = new LinkedList<>();
        Set<String> hset = new HashSet<>();
        q.offer(beginWord);
        hset.add(beginWord);
        int count = 1;
        while (!q.isEmpty()) {
            int qsize = q.size();
            count++;
            for (int i = 0; i < qsize; i++) {
                String temp = q.poll(); 
                char[] arr = temp.toCharArray();
                for (String str : findNeigh(arr, dict)) { /// SHOULD be in the dict
                    if (!hset.contains(str)) {
                        q.offer(str);
                        hset.add(str);
                    }
                    if (hset.contains(endWord)) {
                        return count;
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> findNeigh(char[] arr, Set<String> dict) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            char[] temp = Arrays.copyOf(arr, arr.length); // for each bit
            for (char ch = 'a'; ch <= 'z'; ch++) {
                temp[i] = ch;
                String tar = new String(temp);
                if (!temp.equals(arr) && dict.contains(tar)) {
                    res.add(tar);
                }
            }
        }
        return res;
    }
}
