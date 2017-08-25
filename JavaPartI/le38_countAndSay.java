class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String cur = "1";
        for (int i = 2; i <= n; i++) {
            cur = convertStr(cur);
        }
        return cur;
    }
    
    private String convertStr(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char cur = str.charAt(0);
        int n = str.length();
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(count);
                sb.append(cur);
                count = 1;
                cur = str.charAt(i);
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
}
