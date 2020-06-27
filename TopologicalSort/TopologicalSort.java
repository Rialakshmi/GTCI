import java.util.*;

class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    HashMap<Integer,List<Integer>> graph=new HashMap<>();
    HashMap<Integer,Integer> indegree=new HashMap<>();
    for(int i=0;i<vertices;i++) {
      indegree.put(i,0);
      graph.put(i,new ArrayList<Integer>());
    }
      
    for(int[] edge:edges) {
      int parent=edge[0];
      int child=edge[1];
      graph.get(parent).add(child);
      indegree.put(child,indegree.get(child)+1);
    }
    Queue<Integer> queue=new LinkedList<>();
    for(Map.Entry<Integer,Integer> e:indegree.entrySet()) {
      if(e.getValue()==0)
        queue.offer(e.getKey());
    }

    while(!queue.isEmpty()) {
      int currVertex=queue.poll();
      sortedOrder.add(currVertex);
      List<Integer> children=graph.get(currVertex);
      for(Integer child:children) {
        indegree.put(child,indegree.get(child)-1);
        if(indegree.get(child)==0)
          queue.offer(child);
      }
    }
    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}
