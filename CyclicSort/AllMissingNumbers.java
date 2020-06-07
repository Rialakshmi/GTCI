import java.util.*;

class AllMissingNumbers {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    for(int i=0;i<nums.length;i++) {
      int prev=-1;
      while(nums[i]!=i+1&&prev!=nums[i]) {
        prev=nums[i];
        swap(nums,i,nums[i]-1);
      }
    }

    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=i+1)
      missingNumbers.add(i+1);
    }
    return missingNumbers;
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
