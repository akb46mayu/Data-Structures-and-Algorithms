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
public class Solution {
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
