import java.util.*;

class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
     List<String> list=new ArrayList<>();
        permutation(str.toCharArray(),list,0);
        return list;
    }
    
    public static void permutation(char[] chars,List<String> list,int fixed) {
        if(fixed==chars.length) {
            list.add(String.valueOf(chars));
            return;
        }
        
        if(Character.isDigit(chars[fixed])) {
            permutation(chars,list,fixed+1);
            return;
        }
        
        chars[fixed] = Character.toUpperCase(chars[fixed]);
        permutation(chars,list,fixed+1);
        chars[fixed] = Character.toLowerCase(chars[fixed]);
        permutation(chars,list,fixed+1);
    }

  public static void main(String[] args) {
    List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
    System.out.println(" String permutations are: " + result);

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
    System.out.println(" String permutations are: " + result);
  }
}
