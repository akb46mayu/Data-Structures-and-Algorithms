
/*Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice

You can assume that there is at least one topological order in the graph.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
*/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new  LinkedList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> hash =  new HashMap<DirectedGraphNode, Integer>();
        // find all of the nodes' in degrees (except for 0 indegree)
        for (DirectedGraphNode dn: graph) {
            for (DirectedGraphNode x: dn.neighbors) {
                if (hash.containsKey(x)) {
                    hash.put(x, hash.get(x) + 1);
                } else {
                    hash.put(x, 1);
                }
            }
        }
        // push nodes in the queue for in degree = 0
        for (DirectedGraphNode nd: graph) {
            if (!hash.containsKey(nd)) {
                queue.offer(nd);
                result.add(nd);
            }
        }
        // update the indegrees by removing nodes
        
        while (!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            for (DirectedGraphNode nd: head.neighbors) {
                hash.put(nd, hash.get(nd) - 1);
                if (hash.get(nd) == 0) {
                    queue.offer(nd);
                    result.add(nd);
                }
            }
        }
        return result;
        
    }
}


