public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    int i = 0, j = 0;
    int a = A.size(), b = B.size();
    while(i < a && j < b) {
      if (A.get(i) == B.get(j)) {
        result.add(A.get(i));
        i++;
        j++;
      } else if (A.get(i) < B.get(j)) {
        i++;
      } else {
        j++;
      }
    }
    return result;
  }
}
