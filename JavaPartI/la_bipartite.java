/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // write your solution here
    if (graph == null) {
      return true;
    }
    HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    for (GraphNode node: graph) {
      if (!bfs(node, visited)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean bfs(GraphNode node, HashMap<GraphNode, Integer> visited) {
    if (visited.containsKey(node)) {
      return true;
    }
    Queue<GraphNode> q = new LinkedList<GraphNode>();
    q.offer(node);
    visited.put(node, 0);
    while(!q.isEmpty()) {
      GraphNode cur = q.poll();
      int curgroup = visited.get(cur);
      int nbgroup = Math.abs(1 - curgroup);
      for (GraphNode nb:cur.neighbors) {
        if (!visited.containsKey(nb)) {
          q.offer(nb);
          visited.put(nb, nbgroup);
        } else if (visited.get(nb) != nbgroup) {
          return false;
        }
      }
    }
    return true;
  }
}
