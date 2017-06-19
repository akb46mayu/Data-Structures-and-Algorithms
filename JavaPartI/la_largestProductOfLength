public class Solution {
   public int largestProduct(String[] dict) {
    // Write your solution here.
    Map<String, Integer> hmap = dictToBit(dict);
    Arrays.sort(dict, new Comparator<String>() {
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return 0;
        } else {
          return s1.length() < s2.length() ? 1 : -1;
        }
      } 
    });
    int res = 0;
    for (int i = 1; i < dict.length; i++) {
      for (int j = 0; j < i; j++) {
        int mask1 = hmap.get(dict[i]);
        int mask2 = hmap.get(dict[j]);
        if ((mask1 & mask2) == 0) {
          return dict[i].length() * dict[j].length();
        }
      }
    }
    return res;
  }
  
  private Map<String, Integer> dictToBit(String[] dict) {
    Map<String, Integer> hmap = new HashMap<>();
    for (String str : dict) {
      int integerBit = 0;
      int strLen = str.length();
      for (int i = 0; i < strLen; i++) {
        integerBit |= 1 << (str.charAt(i) - 'a');
      }
      hmap.put(str, integerBit);
    }
    return hmap;
  }
}
