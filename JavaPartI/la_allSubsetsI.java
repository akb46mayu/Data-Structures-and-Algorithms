public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    
    char[] arrayset = set.toCharArray();
    StringBuilder curstring = new StringBuilder();
    combination(arrayset, 0, curstring, result);
    return result;
  }
  
  private void combination(char[] set, int index, StringBuilder curstring, List<String> result) {
    if (set.length == index) {
      result.add(curstring.toString());
      return;
    }
    combination(set, index + 1, curstring.append(set[index]), result);
    curstring.deleteCharAt(curstring.length() - 1);
    combination(set, index + 1, curstring, result);
  }
}
