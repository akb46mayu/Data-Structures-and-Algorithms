public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[j]) {
                j = mid;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
