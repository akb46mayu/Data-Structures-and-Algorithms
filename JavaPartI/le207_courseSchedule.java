
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        // convert point pairs to edges nbh structure
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]); //try add
        }
        // put 0 degrees into the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // bfs
        int count = 0;
        while (!q.isEmpty()) {
            int head = q.poll();
            count ++;
            for (int i =0; i < edges[head].size(); i++) {
                int nbh = (int)edges[head].get(i);
                indegree[nbh]--;
                
                if (indegree[nbh] == 0 ) {
                    q.offer(nbh);
                    
                }
                
            }
        }
        return count == numCourses;
        
    }
}
