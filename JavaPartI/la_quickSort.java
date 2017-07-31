import java.util.Arrays;
public class QuickSort {
	public int[] quickSort(int[] array) {
	    // Write your solution here
		if (array == null){
			return array;
		}
		quickSort(array, 0, array.length-1);
	    return array;
	}
	
	public void quickSort(int[] array, int left, int right){
		if (left >= right){
			return;
		}
		int pivotidx = partition(array, left, right);
		quickSort(array, left, pivotidx-1);
		quickSort(array, pivotidx+1, right);
		
	}
	private void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	private int partition(int[] array, int left, int right){
	    int pivotidx = pivotidxFunc(left, right);
	    int pivotval = array[pivotidx];
	    swap(array, right, pivotidx);
	     // i is the idx all smaller values are before the idx
	    int newi = left;
	    for(int i=left; i<= right; i++){
	    	if (array[i] < pivotval){
	    		swap(array, newi, i);
	    		newi++;
	    	}
	    }
	    swap(array, newi, right);
	    return newi;
	}
	private int pivotidxFunc(int left, int right){
		return left + (int)(Math.random()*(right - left + 1)); //check the meaning of this
	}
	public static void main(String[] args){
		QuickSort qsort = new QuickSort();
		int[] array = {4,2,1,6,3,5};
		qsort.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}
/// second way of partition
  private int partition(int[] arr, int left, int right) {
    int pidx = randNum(left, right);
    int pval = arr[pidx];
    swap(arr, right, pidx);
    int i = left, j = right - 1;
    while (i <= j) {
      if (arr[i] < pval) {
        i++;
      } else {
        swap(arr, i, j--);
      }
    }
    swap(arr, i, right);
    return i;
  }
