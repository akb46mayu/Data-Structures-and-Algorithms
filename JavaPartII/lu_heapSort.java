/*
Given an array, use heapsort to sort it in place.
You can not use java pq api

*/

import java.util.*;
public class Solution {
    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }
        int n = arr.length;
        heapify(arr);
        //System.out.println(Arrays.toString(arr));
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            percDown(arr, 0, i);
        }
    }
    
    private void heapify(int[] arr) {
        // assume n >= 2
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            percDown(arr, i, n);
        }
    }
    
    private void percDown(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxidx = i;
        if (left < n && arr[maxidx] < arr[left]) {
            maxidx = left;
        }
        if (right < n && arr[maxidx] < arr[right]) {
            maxidx = right;
        }
        if (i != maxidx) {
            swap(arr, i, maxidx);
            percDown(arr, maxidx, n);
        }
        
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String args[]) {
        int[] arr = {5, 3, 1, 4, 2, 8, 10};
        //int[] arr = {2,3, 1};
        Solution sol = new Solution();
        sol.heapSort(arr);
        //sol.heapify(arr);
        System.out.println(Arrays.toString(arr));
    }
}
