import java.util.*;

class Permutations {
static List<List<Integer>> list=new ArrayList<>();
  public static List<List<Integer>> findPermutations(int[] nums) {
    helper(nums,0,nums.length,list);
        return list;
    }
    
    public static void helper(int[] nums,int first,int length,List<List<Integer>> list) {
        if(first==length) {
            List<Integer> curr=new ArrayList<>();
            for(int num:nums)
                curr.add(num);
            list.add(curr);
           
        } else {
            for(int i=first;i<length;i++) {
                swap(nums,i,first);
                helper(nums,first+1,length,list);
                swap(nums,i,first);
            }
        }
    }
    
    public static void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

  public static void main(String[] args) {
    List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
    System.out.print("Here are all the permutations: " + result);
  }
}
