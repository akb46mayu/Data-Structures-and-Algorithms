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
// dfs way 2 no return val
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    Map<GraphNode, GraphNode> map = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for(GraphNode node : graph) {
      subCopy(node, map, res);
    }
    return res;
  }
  
  private void subCopy(GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> res) {
    if (map.containsKey(node)) {
      return;
    }
    map.put(node, new GraphNode(node.key));
    for(GraphNode nbh : node.neighbors) {
      subCopy(nbh, map, res);
      map.get(node).neighbors.add(map.get(nbh));
    }
    res.add(map.get(node));
  }
}

////// BFS
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    Map<GraphNode, GraphNode> map = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for(GraphNode node : graph) {
      subCopy(node, map, res);
    }
    return res;
  }
  
  private void subCopy(GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> res) {
    if (map.containsKey(node)) {
      return;
    }
    Queue<GraphNode> q = new LinkedList<>();
    q.offer(node);
    while(!q.isEmpty()) {
      GraphNode temp = q.poll();
      map.put(temp, new GraphNode(temp.key));
      for (GraphNode nbh : temp.neighbors) {
        if (!map.containsKey(nbh)) {
          map.put(nbh, new GraphNode(nbh.key));
          q.offer(nbh);
        }
        map.get(temp).neighbors.add(map.get(nbh));
      }
      res.add(map.get(temp));
    }
  }
}
