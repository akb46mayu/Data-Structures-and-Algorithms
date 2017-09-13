// way 1:
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {  // i is the number of bits one can move
            int prevsize = res.size();
            for (int j = prevsize - 1; j >= 0; j--) {
                int num = res.get(j) | (1 << i);
                res.add(num);
            }
        }
        return res;
    }
}

// way2:

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        res.add(1);
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) { // i is the current maximum bit we want to build
            int prevsize = res.size();
            for (int j = prevsize - 1; j >= 0; j--) {
                int num = res.get(j) | (1 << (i - 1));
                res.add(num);
            }
        }
        return res;
    }
}
