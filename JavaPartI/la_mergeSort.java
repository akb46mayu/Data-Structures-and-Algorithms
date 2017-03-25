public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if (array == null){
			return array;
		}
		int[] helper = new int[array.length];
		
		mergeSort(array, helper, 0, array.length-1);
		return array;
    
  }
  private void mergeSort(int[] array, int[] helper, int left, int right){
		if (left>=right){
			return;
		}
		int mid = left + (right - left)/2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid+1, right);
		merge(array, helper, left, mid, right);
		
	}
  private void merge(int[] array, int[] helper, int left, int mid, int right){
      
      for (int i = left; i<= right; i++){
      	helper[i] = array[i];
      }
      int pt1 = left;
      int pt2 = mid + 1;
      while(pt1 <= mid && pt2 <= right){
      	if (helper[pt1] <= helper[pt2]){
      		array[left++] = helper[pt1++];
      	}
      	else {
      		array[left++] = helper[pt2++];
      	}
      }
      while (pt1<=mid){
      	array[left++] = helper[pt1++];
      }
  
  }
}
