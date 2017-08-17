public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            percDown(A, i, n);
        }
    }
    private void percDown(int[] A, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minidx = i;
        if (left < n && A[minidx] > A[left]) {
            minidx = left;
        }
        if (right < n && A[minidx] > A[right]) {
            minidx = right;
        }
        if (minidx != i) {
            swap(A, i, minidx);
            percDown(A, minidx, n);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
