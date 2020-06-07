class FindCorruptNums {

  public static int[] findNumbers(int[] nums) {
    for(int i=0;i<nums.length;i++) {
      int prev=-1;
      while(nums[i]!=(i+1)&&prev!=nums[i]) {
        prev = nums[i];
        swap(nums,i,nums[i]-1);
      }
    }

    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=(i+1)) {
        return new int[] {nums[i],i+1};
      }
    }
    return new int[] { -1, -1 };
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
