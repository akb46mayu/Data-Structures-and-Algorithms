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



public class Solution2 {
   	  public int[] mergeSort(int[] array) {
		    // Write your solution here.
		    if (array == null || array.length == 0) {
		      return array;
		    }
		    return mergeSortHelper(array, 0, array.length - 1);
		  }
		  
		  private int[] mergeSortHelper(int[] array, int left, int right) {
		    if (left == right) {
		      int[] out = new int[1];
		      out[0] = array[left];
		      return out;
		    }
		    int mid = left + (right - left)/2;
		    int[] leftpart = mergeSortHelper(array, left, mid);
		    int[] rightpart = mergeSortHelper(array, mid + 1, right);
		    return merge(leftpart, rightpart);
		  }
		  
		  private int[] merge(int[] leftpart, int[] rightpart) {
		    int n1 = leftpart.length, n2 = rightpart.length;
		    int[] out = new int[n1 + n2];
		    int i = 0, j = 0, k = 0;
		    while (i < n1 && j < n2) {
		      if (leftpart[i] < rightpart[j]) {
		        out[k++] = leftpart[i++];
		      } else {
		        out[k++] = rightpart[j++];
		      }
		    }
		    
		    while (i < n1) {
		      out[k++] = leftpart[i++];
		    }
		    while (j < n2) {
		      out[k++] = rightpart[j++];
		    }
		    return out;
		  }
}
