import java.util.*;

class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    int n=nums.length;
    List<Integer> missingNumbers = new ArrayList<>();
    HashSet<Integer> hs=new HashSet<>();
    int i=0;
    while(i<nums.length) {
      if(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]) {
        swap(nums,i,nums[i]-1);
      } else
      i++;
    }
    i=0;
    for(;i<n&&missingNumbers.size()<k;i++) {
      if(nums[i]!=(i+1)) {
        missingNumbers.add(i+1);
        hs.add(nums[i]);
      }
      
    }

    for( i=1;missingNumbers.size()<k;i++) {
      int num=i+nums.length;
      if(!hs.contains(num))
      missingNumbers.add(num);
    }

    
    return missingNumbers;
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
