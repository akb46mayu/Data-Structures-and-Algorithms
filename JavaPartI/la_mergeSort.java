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


/// way 2 (recursion with return value)
public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    return mergeHelper(array, 0, array.length - 1);
  }
  
  
  private int[] mergeHelper(int[] array, int left, int right) {
    if (left == right) {
      return new int[]{array[left]};
    }
    int mid = left + (right - left) / 2;
    int[] arr1 = mergeHelper(array, left, mid);
    int[] arr2 = mergeHelper(array, mid + 1, right);
    return merge(arr1, arr2);
  }
  
  private int[] merge(int[] arr1, int[] arr2) {
    int len1 = arr1.length, len2 = arr2.length;
    int i = 0, j = 0, k = 0;
    int[] res = new int[len1 + len2];
    while (i < len1 && j < len2) {
      if (arr1[i] < arr2[j]) {
        res[k++] = arr1[i++];
      } else {
        res[k++] = arr2[j++];
      }
    }
    while (i != len1) {
      res[k++] = arr1[i++];
      
    }
    while (j != len2) {
      res[k++] = arr2[j++];
    }
    return res;
  }
}
