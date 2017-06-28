public class Solution {
  static class MyComparator implements Comparator<Integer> {
    private Map<Integer, Integer> hmap;
    public MyComparator(int[] arr) {
      hmap = new HashMap<>();
      for (int i = 0; i < arr.length; i++) {
        hmap.put(arr[i], i);
      }
    }
    public int compare(Integer i1, Integer i2) {
      Integer idx1 = hmap.get(i1);
      Integer idx2 = hmap.get(i2);
      if (idx1 != null && idx2 != null) {
        return idx1.compareTo(idx2);
      } else if (idx1 == null && idx2 == null) {
        return i1.compareTo(i2);
      }
      return idx1 != null ? -1 : 1;
    }
  }
  
  public int[] sortSpecial(int[] A1, int[] A2) {
    // Write your solution here.
    Integer[] A11 = intToInteger(A1);
    Arrays.sort(A11, new MyComparator(A2));
    IntegerToInt(A11, A1);
    return A1;
  }
  
  private Integer[] intToInteger(int[] arr) {
    Integer[] array = new Integer[arr.length];
    for(int i = 0; i < arr.length; i++) {
      array[i] = arr[i];
    }
    return array;
  }
  
  private void IntegerToInt(Integer[] array, int[] arr) {
    for(int i = 0; i < array.length; i++) {
      arr[i] = array[i];
    }
  }
  
}
