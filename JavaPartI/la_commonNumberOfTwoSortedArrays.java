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
/////

public class Solution2 {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>();
    int a = A.size(), b = B.size();
    for (int i = 0; i < a; i++) {
      Integer temp = countA.get(A.get(i));
      if (temp == null) {
        countA.put(A.get(i), 1);
      } else {
        countA.put(A.get(i), temp + 1);
      }
    }
    //
    for (int i = 0; i < b; i++) {
      Integer temp = countB.get(B.get(i));
      if (temp == null) {
        countB.put(B.get(i), 1);
      } else {
        countB.put(B.get(i), temp + 1);
      }
    }
    //
    for(Map.Entry<Integer, Integer> entry : countA.entrySet()) {
      if (countB.containsKey(entry.getKey())) {
        int lenInt = Math.min(countB.get(entry.getKey()), entry.getValue());
        for (int i = 0; i < lenInt; i++) {
          result.add(entry.getKey());
        }
      }
    }
    return result;
  }
}
/// with one hashtable (my sol)
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    int a = A.size(), b = B.size();
    if (a < b) {
      Map<Integer, Integer> map = numCount(A);
      result = commonHelper(B, map);
    } else {
      Map<Integer, Integer> map = numCount(B);
      result = commonHelper(A, map);
    }
    return result;
  }
  private List<Integer> commonHelper(List<Integer> s, Map<Integer, Integer> map) {
    int n = s.size();
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      int num = s.get(i);
      Integer count = map.get(num);
      if (count!= null && count > 0) {
        result.add(num);
        map.put(num, --count);
      }
    }
    return result;
  }
  private Map<Integer, Integer> numCount(List<Integer> list) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = list.size();
    for (int i = 0; i < n; i++) {
      int num = list.get(i);
      Integer count = map.get(num);
      if (count != null) {
        map.put(num, count + 1);
      } else {
        map.put(num, 1);
      }
    }
    return map;
  }
}
