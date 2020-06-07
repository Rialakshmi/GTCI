class CyclicSort {

  public static void sort(int[] nums) {
  for(int i=0;i<nums.length;i++) {
    while(nums[i]!=(i+1)) {
      swap(nums,i,nums[i]-1);
    }
  }
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
