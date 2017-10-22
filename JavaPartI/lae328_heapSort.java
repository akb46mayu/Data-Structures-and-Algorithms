public class Solution {
  public int[] heapsort(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int n = array.length;
    heapify(array);
    for (int i = n - 1; i > 0; i--) {
      swap(array, 0, i);
      percDown(array, 0, i);
    }
    return array;
  }
  
  private void heapify(int[] A) {
    int n = A.length;
    int endidx = n / 2 - 1;
    for (int i = endidx; i >= 0; i--) {
      percDown(A, i, n);
    }
  }
  
  private void percDown(int[] A, int i, int n) {
    int left = 2 * i + 1, right = 2 * i + 2;
    int maxidx = i;
    if (left < n && A[left] > A[i]) {
      maxidx = left;
    }
    if (right < n && A[right] > A[maxidx]) {
      maxidx = right;
    }
    if (maxidx != i) {
      swap(A, i, maxidx);
      percDown(A, maxidx, n);
    }
  }
  
  private void swap(int[] A, int i, int j) {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
  }
  
}
