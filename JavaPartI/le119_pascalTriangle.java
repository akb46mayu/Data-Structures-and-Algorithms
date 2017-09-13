class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        res.add(1);
        for (int k = 2; k <= rowIndex; k++) {
            int prevsize = res.size();
            for (int i = 0; i < prevsize - 1; i++) {
                int sum = res.get(i) + res.get(i + 1);
                res.set(i, sum);
            }
            res.add(0, 1);
        }
        return res;
    }
}
