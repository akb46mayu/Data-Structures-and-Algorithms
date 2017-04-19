public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int neg = 0, zero = neg, pos = array.length - 1;
    while(zero <= pos) {
      if (array[zero] == -1) {
        swap(array, neg++, zero++);
      } else if (array[zero] == 0) {
        zero++;
      } else {
        swap(array, zero, pos--);
      }
    }
    return array;
  }
  
  private void swap(int[] array, int start, int end){
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
   }
}
