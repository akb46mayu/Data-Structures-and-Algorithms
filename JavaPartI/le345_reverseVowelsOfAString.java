class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] arr = s.toCharArray();
        while(i < j) {
            while (i < j && !isVow(arr[i])) {
                i++;
            }
            while (i < j && !isVow(arr[j])) {
                j--;
            }
            swap(arr, i++, j--);
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private boolean isVow(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
          ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) {
            return true;
        }
        return false;
    }
}
//// sol use set
class Solution2 {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        
        char[] arr = s.toCharArray();
        Set<Character> hset = generateVow();
        while(i < j) {
            while (i < j && !hset.contains(arr[i])) {
                i++;
            }
            while (i < j && !hset.contains(arr[j])) {
                j--;
            }
            swap(arr, i++, j--);
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private Set<Character> generateVow() {
        Set<Character> hset = new HashSet<>();
        hset.add('a');
        hset.add('e');
        hset.add('i');
        hset.add('o');
        hset.add('u');
        hset.add('A');
        hset.add('E');
        hset.add('I');
        hset.add('O');
        hset.add('U');
        return hset;
    } 
}
