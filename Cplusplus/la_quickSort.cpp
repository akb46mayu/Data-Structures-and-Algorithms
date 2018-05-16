
class Solution {
 public:
  vector<int> quickSort(vector<int> array) {
    // write your solution here
    quicksort(array, 0, array.size() - 1);
    return array;
  }
  
  void quicksort(vector<int> &arr, int left, int right) {
  	if (left >= right) {
    	return;
    }
    int partidx = partition(arr, left, right);
    quicksort(arr, left, partidx - 1);
    quicksort(arr, partidx + 1, right);
  }
  
  int partition(vector<int> &arr, int left, int right) {
  	int randidx = genRange(left, right);
    int pivot = arr[randidx];
    swap(arr, randidx, right);
    int i = left, j = left;
    while (i <= right) {
    	if (arr[i] < pivot) {
      	swap(arr, i, j++);
      } 
      i++;
    }
    swap(arr, j, right);
    return j;
  
  }
  
  int genRange(int min, int max) {
    return min + rand() % (max - min + 1);
  }
  
  void swap(vector<int> &arr, int i, int j) {
  	int c = arr[i];
    arr[i] = arr[j];
    arr[j] = c;
  }
};
