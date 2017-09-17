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


// way 2
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] check =  new boolean[n]; // true: prime
        Arrays.fill(check, true);
        if (n <= 2) {
            return count;
        }
        check[0] = false;
        check[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (check[i] == true) {
               for (int j = i; j * i <= n - 1; j++) {
                   check[j * i] = false;
               } 
            }
        }
        for (boolean j : check) {
            if (j == true) {
                count++;
            }
        }
        return count;
    }
}
