class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return list;
        }
        int one = 0, two = 0;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        for (int i : nums) {
            if (i == one) {
                count1++;
            } else if (i == two) {
                count2++;
            } else if (count1 == 0) {
                one = i;
                count1++;
            } else if (count2 == 0) {
                two = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (one == i) {
                count1++;
            } else if (two == i) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            list.add(one);
        }
        if (count2 > n / 3) {
            list.add(two);
        }
        return list;
    }
}
