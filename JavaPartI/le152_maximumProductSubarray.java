class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = min;
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * temp, nums[i] * max));
            res = Math.max(res, max);
        }
        return res;
    }
}
