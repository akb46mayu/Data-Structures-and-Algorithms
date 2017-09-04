public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return;
    }
    for (int i = array.length - 1; i >= 1; i--) {
      int idx = (int)(Math.random() * (i + 1));
      swap(array, idx, i);
    }
  }
  
  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
////////
public class Solution2 {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return;
    }
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      int offset = (int)(Math.random() * (n - i));
      swap(array, i + offset, i);
    }
  }
  
  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
/// leet384 with reset version
class Solution {
    private int[] arr;
    private int[] org;
    public Solution(int[] nums) {
        if (nums == null) {
            return;
        }
        arr = nums;
        int n = nums.length;
        org = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return org;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            int idx = (int) ((i + 1) * Math.random());
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
