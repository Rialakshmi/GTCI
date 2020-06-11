import java.util.*;

class GenerateParentheses {

  public static List<String> generateValidParentheses(int num) {
    List<String> result = new ArrayList<String>();
    combinations(num,0,0,num,"",result);
    return result;
  }

  public static void combinations(int num,int openP,int closeP,int maxP,String generate,List<String> result) {
    if(generate.length()==num*2)  {
      result.add(generate);
      return;
    }

    if(openP<maxP)
    combinations(num,openP+1,closeP,maxP,generate+"(",result);

    if(closeP<openP)
    combinations(num,openP,closeP+1,maxP,generate+")",result);

  }

  public static void main(String[] args) {
    List<String> result = GenerateParentheses.generateValidParentheses(2);
    System.out.println("All combinations of balanced parentheses are: " + result);

    result = GenerateParentheses.generateValidParentheses(3);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
