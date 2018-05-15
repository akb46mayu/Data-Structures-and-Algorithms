class Solution {
 public:
  vector<int> solve(vector<int> array) {
    // write your solution here
    
    if (array.size() == 0) return array;
    int len = array.size();
    
    for (int i = 0; i < len; i++) {
    	int minidx = i, minval = array[i];
      for (int j = i + 1; j < len; j++) {
      	if (array[j] < minval) {
        	minidx = j;
          minval = array[j];
        }
      }
      swap(array[i], array[minidx]);
    }
    return array;
  }
  
  void swap(int &a, int &b) {
  	int c = a;
    a = b;
    b = c;
  }
};
