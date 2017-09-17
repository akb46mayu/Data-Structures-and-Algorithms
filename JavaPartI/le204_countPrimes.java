class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] check =  new boolean[n]; // true: not prime
        
        if (n <= 2) {
            return count;
        }
        for (int i = 2; i < n; i++) {
            if (check[i] == false) {
                count++;
               for (int j = i; j <= (n - 1) / i; j++) {
                   check[j * i] = true;
               } 
            }
        }
        return count;
    }
}
