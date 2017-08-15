/*
Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

*/


public class StringIterator {
    String str;
    int i = 0;
    int size = 0;
    int count = 0;
    char cur;
    public StringIterator(String compressedString) {
        str = compressedString;
        size = str.length();
    }
    
    public char next() {
        if (hasNext()) {
            if (count == 0) {
                cur = str.charAt(i);
                int j = i + 1;
                while (j < size && str.charAt(j) - '0' >= 0 && str.charAt(j) - '0' <= 9) {
                    count = count * 10 + str.charAt(j) - '0';
                    j++;
                }
                count--;
                i = j;
            } else {
                count--;
            }
            return cur;
        }
        return ' ';
    }
    
    public boolean hasNext() {
        return count > 0 || i < size; // has to be a new ch
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
