
public class Solution {
  public int shiftPosition(int[] array) {
    // Write your solution here
  		if (array == null || array.length == 0) {
  			return -1;
  		}
  		int start = 0, end = array.length - 1;
  		while (start + 1 < end) {
  			int mid = start + (end - start)/2;
  			if (array[mid] <= array[end]) {
  				end = mid;
  			} else {
  				start = mid;
  			}
  			
  		}
  		if (array[start] > array[end]) {
  			return end;
  		} else {
  			return start;
  		}
  }
}
