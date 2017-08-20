class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // generate the general dictionary 
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }
        dict.add(beginWord);
        Map<String, List<String>> neimap = new HashMap<>();
        Map<String, Integer> levmap = new HashMap<>();
        for (String str : dict) {
            neimap.put(str, new ArrayList<String>());
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        levmap.put(beginWord, 1);
        // bfs
        while (!q.isEmpty()) {
            int qsize = q.size();
            boolean findSol = false;
            for (int i = 0; i < qsize; i++) { // at each level
                if (findSol == true) {
                    break;
                }
                String temp = q.poll();  
                int count = levmap.get(temp);
                char[] arr = temp.toCharArray();
                for (String str : findNeigh(arr, dict)) { /// SHOULD be in the dict
                    neimap.get(temp).add(str);  // add the string to neigh
                    if (!levmap.containsKey(str)) {
                        levmap.put(str, count + 1);   
                        if (!str.equals(endWord)) {
                            q.offer(str);
                        } else {
                            findSol = true;
                        }
                    }
                }
                if (findSol) {
                    break;
                } 
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        dfs(beginWord, res, sub, endWord, neimap, levmap);
        return res;
    }
    private void dfs(String cur, List<List<String>> res, List<String> sub, 
                     String endWord,Map<String, List<String>> neimap, 
                     Map<String, Integer> levmap) {
        sub.add(cur);
        if (cur.equals(endWord)) {
            res.add(new ArrayList<String>(sub));
        } else {
            for (String str : neimap.get(cur)) {
                if (levmap.get(cur) + 1 == levmap.get(str)) {
                    dfs(str, res, sub, endWord, neimap, levmap);
                }
            }
            
        }
        sub.remove(sub.size() - 1);
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
