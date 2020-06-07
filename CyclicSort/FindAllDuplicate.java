class FindAllDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
       List<Integer> duplicateNumbers = new ArrayList<>();
    for(int i=0;i<nums.length;i++) {
      int prev=-1;
      while(nums[i]!=i+1) {
        if(prev==nums[i]) {
          hs.add(prev);
          break;
        }
        prev=nums[i];
        swap(nums,i,nums[i]-1);

      }
    }
        
    duplicateNumbers.addAll(hs);
    return duplicateNumbers; 
    }
    
    public  void swap(int[] nums,int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
