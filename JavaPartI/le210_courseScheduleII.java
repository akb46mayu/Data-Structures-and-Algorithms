public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
                int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList();
        int[] result = new int[numCourses];
        
        //
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();   
        }
        // assigna
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
   
        // put 0 indegree to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        // bfs
        int count = 0;
        while (!q.isEmpty()) {
            int head = q.poll();
            result[count++] = head;
            for (int i = 0; i < edges[head].size(); i++) {
                int pointer = (int)edges[head].get(i);
                indegree[pointer]--;
                if (indegree[pointer] == 0) {
                    q.offer(pointer);
                }
                
            }
        }
        if (count == numCourses)  return result;
        return new int[0];
    }
}
