// mathematical solution
public class Solution {
  public List<Integer> putChair(char[][] gym) {
    // write your solution here
    int m = gym.length, n = gym[0].length;
    List<Integer> xdirec = new ArrayList<>();
    List<Integer> ydirec = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'E') {
          xdirec.add(i);
          ydirec.add(j);
        }
      }
    }
    res.add(getPos(xdirec, 0));
    res.add(getPos(ydirec, 1));
    return res;
  }
  
  private int getPos(List<Integer> dlist, int direc) {
    // direc 0 : x direc
    if (direc == 1) {
        Collections.sort(dlist);
    }
    int n = dlist.size();
    return dlist.get(n / 2);
  } 
}
// bfs
