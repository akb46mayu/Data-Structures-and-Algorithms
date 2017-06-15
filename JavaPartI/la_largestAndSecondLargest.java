public class Solution {
  static class Element {
    int value;
    List<Integer> nbh;
    Element(int value) {
      this.value = value;
      this.nbh = new ArrayList<Integer>();
    }
  }
  
  public int[] largestAndSecond(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the second largest number.
    int n = array.length;
    Element[] helper = convert(array);
    while (n > 1) {
      subCompare(helper, n);
      n = (n + 1)/2;
    }
    return findMax(helper);
  }
  
    private void swap(Element[] helper, int i, int j) {
    Element temp = helper[i];
    helper[i] = helper[j];
    helper[j] = temp;
  }
  
  private void subCompare(Element[] helper, int tlen) {
    for (int i = 0; i < tlen / 2; i++) {
      if (helper[i].value < helper[tlen - i - 1].value) {
        swap(helper, i, tlen - i - 1);
      }
      helper[i].nbh.add(helper[tlen - i - 1].value);
    }
  }
  
  private Element[] convert(int[] array) {
    int n = array.length;
    Element[] helper = new Element[n];
    for (int i = 0; i < n; i++) {
      helper[i] = new Element(array[i]);
    }
    return helper;
  }
  
  private int[] findMax(Element[] helper) {
	int maxval = Integer.MIN_VALUE;
    for (Integer val : helper[0].nbh) {
      maxval = Math.max(maxval, val);
    }
    return new int[] {helper[0].value, maxval};
  }
}
