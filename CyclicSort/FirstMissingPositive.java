class FirstMissingPositive {

  public static int findNumber(int[] nums) {
    int n=nums.length;
    for(int i=0;i<nums.length;i++) {
      while(nums[i]>0&&nums[i]<=n&&nums[i]!=(i+1)) {
        swap(nums,i,nums[i]-1);
      }
    }

    for(int i=0;i<n;i++) {
      if(nums[i]!=(i+1))
        return i+1;
    }
    return -1;
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
