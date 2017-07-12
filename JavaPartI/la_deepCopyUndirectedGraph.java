/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {  // dfs
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    if (graph == null) {
      return null;
    }
    Map<GraphNode, GraphNode> hmap = new HashMap<>();
    for (GraphNode node: graph) {
       copyGraph(node, hmap);
    }
    return new ArrayList<GraphNode>(hmap.values());
  }
  
  private GraphNode copyGraph(GraphNode input, Map<GraphNode, GraphNode> hmap) {
    if (input == null) {
      return null;
    }
    if (hmap.containsKey(input)) {
      return hmap.get(input);
    }
    GraphNode dupNode = new GraphNode(input.key);
    hmap.put(input, dupNode);
    for (GraphNode gnode : input.neighbors) {
      dupNode.neighbors.add(copyGraph(gnode, hmap));
    }
    return dupNode;
  }
}

////// BFS
public class Solution2 {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    Map<GraphNode, GraphNode> hmap = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for (GraphNode node : graph) {
      if (!hmap.containsKey(node)) {
        copyHelper(node, res, hmap);
      }
    }
    return res;
  }
  
  private void copyHelper(GraphNode node, List<GraphNode> res, Map<GraphNode, GraphNode> hmap) {
    // assume node has not been visited
    Queue<GraphNode> q = new LinkedList<>();
    q.offer(node);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        GraphNode popnode = q.poll();
        if (!hmap.containsKey(popnode)) {
          hmap.put(popnode, new GraphNode(popnode.key));
        }
        for (GraphNode nbh : popnode.neighbors) {
          if (!hmap.containsKey(nbh)) {
            hmap.put(nbh, new GraphNode(nbh.key));
            q.offer(nbh);
          }
          hmap.get(popnode).neighbors.add(hmap.get(nbh));
        }
        res.add(hmap.get(popnode));
      }
    }
  }
}
