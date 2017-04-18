public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    char[] cur = set.toCharArray();
    helper(cur, 0, result);
    return result;
  }
  
  private void helper(char[] cur, int index,  List<String> result) {
    if (cur.length == index) {
      result.add(new String(cur));
      return;
    }
    for (int i = index; i < cur.length; i++) {
      swap(cur, index, i);
      helper(cur, index + 1, result);
      swap(cur, i, index);
    }
    
  }
  
  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
    
  }
  

}
