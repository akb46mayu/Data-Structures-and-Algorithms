class Solution {
 public:
  int binarySearch(vector<int> array, int target) {
    // write your solution here
    if (array.size() == 0) {
    	return -1;
    }
    int start = 0, end = array.size() - 1;
    while (start <= end) { 
    	int mid = start + (end - start) / 2;
      if (array[mid] == target) {
      	return mid;
      } else if (array[mid] < target) {
      	start = mid + 1;
      } else {
      	end = mid - 1;
      }
    }
    return -1;
  }
};
