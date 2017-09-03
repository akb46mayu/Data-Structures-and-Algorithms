class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hset = getDict(wordDict);
        Map<String, List<String>> hmap = new HashMap<>();
        return dfs(s, hset, hmap);
    }
    
    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> hmap) {
        if (hmap.containsKey(s)) {
            return hmap.get(s);
        }
        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), dict, hmap);
                for (String str : sublist) {
                    res.add(word + (str.length() == 0 ? "" : " ") + str);
                }
            }
        }
        hmap.put(s, res);
        return res;
    }
    
    private Set<String> getDict(List<String> wordDict) {
        Set<String> hset = new HashSet<>();
        for (String str : wordDict) {
            hset.add(str);
        }
        return hset;
    }
}
