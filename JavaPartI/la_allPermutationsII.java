// with duplicates 
public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    char[] arr = set.toCharArray();
    permuteHelper(arr, 0, result);
    return result;
  }
  
  private void permuteHelper(char[] arr, int level, List<String> result) {
    if (level == arr.length) {
      result.add(new String(arr));
      return;
    }
    HashSet<Character> hset = new HashSet<Character>();
    for (int i = level; i < arr.length; i++) {
      if (!hset.contains(arr[i])) {
        hset.add(arr[i]);
        swap(arr, level, i);
        permuteHelper(arr, level + 1, result);
        swap(arr, level, i);
      }
    }
  }
  private void swap(char[] arr, int left, int right) {
    char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
