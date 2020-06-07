class FindDuplicate {

  public static int findNumber(int[] nums) {
    for(int i=0;i<nums.length;i++) {
      int prev=-1;
      while(nums[i]!=(i+1)) {
        if(nums[i]==prev)
        return prev;
        prev=nums[i];
        swap(nums,i,nums[i]-1);
      }
    }
    return -1;
  }

  public static void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
