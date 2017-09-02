class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int idx = 0;
        while(str.charAt(idx) == ' ') {
            idx++;
        }
        int sign = 1;
        if (str.charAt(idx) == '-') {
            idx++;
            sign = -1;
        }   else if (str.charAt(idx) == '+') {
            idx++;
        } 
        long sum = 0;
        while(idx < n && (str.charAt(idx) - '0' >= 0 && str.charAt(idx) - '0' <= 9)) {
            int cur = str.charAt(idx) - '0';
            sum = 10 * sum + cur;
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && sign * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            idx++;
        }
        return (int) sum * sign;
    }
}
