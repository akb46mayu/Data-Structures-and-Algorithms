public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    char[] arr = set.toCharArray();
    permuteHelper(arr, 0 ,res);
    return res;
  }
  private void permuteHelper(char[] arr, int level, List<String> res) {
    if (level == arr.length) {
      res.add(new String(arr)); //?
      return;
    }
    for (int i = level; i < arr.length; i++) {
      swap(arr, i, level);
      permuteHelper(arr, level + 1, res);
      swap(arr, i, level);
    }
  }
  private void swap(char[] arr, int i, int j) {
    char ch = arr[i];
    arr[i] = arr[j];
    arr[j] = ch;
  }
}
