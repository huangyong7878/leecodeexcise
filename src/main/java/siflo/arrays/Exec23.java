package siflo.arrays;

import java.util.Map;

public class Exec23 {
  public void rotate(int[] nums, int k) {
    if(nums.length%2==0 && k==nums.length/2){
      for(int i=0;i<k;i++){
        int t = nums[i];
        nums[i] = nums[i+k];
        nums[i+k] = t;
      }
      return;
    }

    for(int i = 0;i<k;i++){
      int t = nums[nums.length-1];
      for(int j=nums.length-1;j>0;j--)
      {
        nums[j] = nums[j-1];
      }
      nums[0] = t;
    }
  }
  public void reverse3times(int[] nums, int k) {
   k%=nums.length;
    //first reverse all
    reverse(nums,0,nums.length-1);
    reverse(nums,0,k-1);
    reverse(nums,k,nums.length-1);
  }
  public void reverse(int[] nums, int start, int end) {
    while(start<end){
      nums[start] = nums[start]^nums[end];
      nums[end] = nums[start]^nums[end];
      nums[start] = nums[end]^nums[start];
      start++;
      end--;
    }
  }

  public static void main(String[] args)throws Exception{
    int[] nums = {1,2,3,4,5,6};
    int k = 3;
    new Exec23().reverse3times(nums,k);
    for(int i=0;i<nums.length;i++){
      System.out.println(nums[i]);
    }
  }
}
