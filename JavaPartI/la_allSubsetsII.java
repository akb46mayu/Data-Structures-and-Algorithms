public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> res = new ArrayList<String>();
    if (set == null) {
      return res;
    }
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    findSubSets(arr, res, sb, 0);
    return res;
  }
  
  private void findSubSets(char[] arr, List<String> res, StringBuilder sb, int level) {
    if (arr.length == level) {
      res.add(sb.toString());
      return;
    }
    findSubSets(arr, res, sb.append(arr[level]), level + 1);
    sb.deleteCharAt(sb.length() - 1);
    while(level + 1 <= arr.length - 1 && arr[level] == arr[level + 1]) {
      level++;
    }
    findSubSets(arr, res, sb, level + 1);
  }
}
