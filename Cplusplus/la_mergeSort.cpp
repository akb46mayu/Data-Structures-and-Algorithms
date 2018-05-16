
class Solution {
 public:
  vector<int> mergeSort(vector<int> array) {
    // write your solution here
    
    int len = array.size();
    if (len == 0) {
    	return array;
    }
    mergesort(array, 0, len - 1);
    return array;
  }
  
  void merge(vector<int> &arr, int start, int rights, int end) {
  	int lefte = rights - 1;
    int carr[end - start + 1];
    int i = start, j = rights, idx = 0;
    while (i <= lefte && j <= end) {
    	if (arr[i] < arr[j]) {
        carr[idx++] = arr[i++];
      } else {
        carr[idx++] = arr[j++];
      }
    }
    while (i <= lefte) {
    	carr[idx++] = arr[i++];
    }
    while (j <= end) {
    	carr[idx++] = arr[j++];
    }
    int k = start, q = 0;
    while(k <= end) {
    	arr[k++] = carr[q++];
    }
  }
  
  void mergesort(vector<int> &arr, int start, int end) {
  	if (start >= end) {
    	return;
    }
    int mid = (start + end) / 2;
    mergesort(arr, start, mid);
    mergesort(arr, mid + 1, end);
    merge(arr, start, mid + 1, end);
  
  }
};
