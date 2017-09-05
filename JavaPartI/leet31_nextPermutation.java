class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int idx = 0;
        int start = 0;
        for (int i = n - 2; i >= 0; i--) {
            idx = i;
            int min = Integer.MAX_VALUE;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    if (nums[j] < min) {
                        idx = j;
                        min = nums[j];
                    }
                }
            }
            if (idx != i) {
                start = i;
                swap(nums, idx, i);
                break;
            }
        }

        int end = n - 1;
        if (idx == 0 && start == 0) {
           reverse(nums, start, end);
        } else {
           reverse(nums, start + 1, end);
        }
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            if (nums[start] > nums[end]) {
                swap(nums, start, end);
            }
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
