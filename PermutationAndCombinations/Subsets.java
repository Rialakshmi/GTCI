import java.util.*;

class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    permutations(nums,0,subsets,new ArrayList<Integer>());
    return subsets;
  }

  public static void permutations(int[] nums,int index,List<List<Integer>> subsets,List<Integer> curr) {
    if(index>nums.length)
    return;
    subsets.add(new ArrayList<Integer>(curr));
    for(int i=index;i<nums.length;i++) {
      curr.add(nums[i]);
      permutations(nums,i+1,subsets,curr);
      curr.remove(curr.size()-1);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
