import java.util.*;

class SubsetWithDuplicates {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
        subsets(nums,0,nums.length,new ArrayList<Integer>(),list);
        return list;
  }

   public static void subsets(int[] nums,int first,int length,List<Integer> curr,List<List<Integer>> list) {
        list.add(new ArrayList<Integer>(curr));
       
        for(int i=first;i<length;i++) {
            curr.add(nums[i]);
            subsets(nums,i+1,length,curr,list);
            curr.remove(curr.size()-1);
        }
    }

  public static void main(String[] args) {
    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
