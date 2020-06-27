import java.util.*;

class AlienDictionary {
  public static String findOrder(String[] words) {
   if(words==null||words.length==0)
            return "";
        StringBuffer sb=new StringBuffer();
        HashMap<Character,List<Character>> graph=new HashMap<>();
        HashMap<Character,Integer> indegree=new HashMap<>();
        for(String word:words) {
            for(char c:word.toCharArray()) {
                indegree.put(c,0);
                graph.put(c,new ArrayList<>());
            }
        }
        
        for(int i=0;i<words.length-1;i++) {
            String word1=words[i];
            String word2=words[i+1];
            for(int j=0;j<Math.min(word1.length(),word2.length());j++) {
                char parent=word1.charAt(j);
                char child=word2.charAt(j);
                if(parent!=child) {
                    graph.get(parent).add(child);
                    indegree.put(child,indegree.get(child)+1);
                    break;
                }
            }
        }
        
        Queue<Character> queue=new LinkedList<>();
        
        for(Map.Entry<Character,Integer> e:indegree.entrySet())
            if(e.getValue()==0)
                queue.offer(e.getKey());
        
        
        while(!queue.isEmpty()) {
            char curr=queue.poll();
            sb.append(curr);
            List<Character> children=graph.get(curr);
            for(Character child:children) {
                indegree.put(child,indegree.get(child)-1);
                if(indegree.get(child)==0)
                    queue.offer(child);
            }
        }
        
        return sb.toString();
  }

  public static void main(String[] args) {
    
    String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
    System.out.println("Character order: " + result);
    result = AlienDictionary.findOrder(new String[] { "abc", "ab" });
    System.out.println("Character order: " + result);
    result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
    System.out.println("Character order: " + result);
  }
}
