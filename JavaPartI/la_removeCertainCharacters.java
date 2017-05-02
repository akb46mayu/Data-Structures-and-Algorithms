public class Solution {
  public String remove(String input, String t) {
    // Write your solution here.
    if (input.length() == 0 || t.length() == 0) {
      return input;
    }
    Set<Character> set = setBuilder(t);
    char[] arr = input.toCharArray();
    int slow = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!set.contains(arr[i])) {
        arr[slow++] = arr[i];
      }
    }
    return new String(arr, 0 , slow);
  }
  private Set<Character> setBuilder(String t) {
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
