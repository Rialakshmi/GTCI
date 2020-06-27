import java.util.*;

class TaskScheduling {
  public static boolean isSchedulingPossible(int numCourses, int[][] prerequisites) {
    HashMap<Integer,List<Integer>> graph=new HashMap<>();
        HashMap<Integer,Integer> indegree=new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            graph.put(i,new ArrayList<Integer>());
            indegree.put(i,0);
        }
        
        for(int[] map:prerequisites) {
            int parent=map[0];
            int child=map[1];
            graph.get(parent).add(child);
            indegree.put(child,indegree.get(child)+1);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(Map.Entry<Integer,Integer> e:indegree.entrySet()) {
            if(e.getValue()==0) {
                queue.offer(e.getKey());
            }
        }
        int numCourse=0;
        while(!queue.isEmpty()) {
            int currVertex=queue.poll();
            numCourse++;
            List<Integer> children=graph.get(currVertex);
            for(Integer child:children) {
                indegree.put(child,indegree.get(child)-1);
                if(indegree.get(child)==0)
                    queue.offer(child);
            }
        }
        
        if(numCourse==numCourses)
            return true;
        else
            return false;
  }

  public static void main(String[] args) {

    boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
        new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println("Tasks execution possible: " + result);
  }
}
