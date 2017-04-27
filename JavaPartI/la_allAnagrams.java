public class Solution {
  List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (l == null || l.length() == 0) {
      return result;
    }
    HashMap<Character, Integer> hmap = getHash(s);
    int n = l.length();
    int numberOfMatch = 0;  // when it is size, we put it in the result
    for (int i = 0; i < n; i++) {
      char temp = l.charAt(i);
      if(hmap.containsKey(temp)) {
        hmap.put(temp, hmap.get(temp) - 1);
        if (hmap.get(temp) == 0) {
          numberOfMatch++;
        }
      } 
      // pop left element
      if (i >= s.length()) {
        char temppop = l.charAt(i - s.length());
        if (hmap.containsKey(temppop)) {
          hmap.put(temppop, hmap.get(temppop) + 1);
          if (hmap.get(temppop) == 1) {
            numberOfMatch--;
          }
        }
      }
      //
      if (numberOfMatch == hmap.size()) {
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }
  
  private HashMap<Character, Integer> getHash(String s) {
    HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char temp = s.charAt(i);
      if(!hmap.containsKey(temp)) {
        hmap.put(temp, 1);
      } else {
        hmap.put(temp, 1 + hmap.get(temp));
      }
    }
    return hmap;
  }
}
