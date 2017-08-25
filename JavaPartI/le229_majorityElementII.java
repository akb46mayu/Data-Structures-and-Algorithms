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
////// version 2 lai


public class Solution {
  public List<Integer> majority(int[] array) {
    // write your solution here
    int n = array.length;
    int one = 0, two = 0;
    int ct1 = 0, ct2 = 0;
    List<Integer> res = new ArrayList<>();
    for (int i : array) {
      if (i == one) {
        ct1++;
      } else if (i == two) {
        ct2++;
      } else if (ct1 == 0) {
        one = i;
        ct1++;
      } else if (ct2 == 0) {
        two = i;
        ct2++;
      } else {
        ct1--;
        ct2--;
      }
    }
    ct1 = 0;
    ct2 = 0;
    int ct3 = 0;
    int onepos = 0, twopos = 0;
    boolean findone = false, findtwo = false;
    for (int i = 0; i < n; i++) {
      if (array[i] == one) {
        ct1++;
        if (findone == false) {
          onepos = i;
          findone = true;
        }
      } else if (array[i] == two) {
        ct2++;
        if (findtwo == false) {
          twopos = i;
          findtwo = true;
        }
      }
    }
    if (onepos > twopos) {
      int tmp = one;
      one = two;
      two = tmp;
      tmp = ct1;
      ct1 = ct2;
      ct2 = tmp;
    }
    if (ct1 > n / 3) {
      res.add(one);
    }
    if (ct2 > n / 3) {
      res.add(two);
    }
    return res;
  }
}
