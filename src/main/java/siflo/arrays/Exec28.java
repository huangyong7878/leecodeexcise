package siflo.arrays;

public class Exec28 {

  public static void swap(int i,int j,int[] nums){
   if(i==j)
     return;
    nums[i] = nums[i]^nums[j];
    nums[j] = nums[i]^nums[j];
    nums[i] = nums[j]^nums[i];

  }

  /**
   * 假设第一个元素就是0，
   * 假设有两个指针 一个指向非零，一个指向当前
   * 当前元素是0时，++
   * 当前元素不是0时，交换,非零指针++.
   *
   *
   * @param nums
   */
  public static void moveZeroes(int[] nums) {
    int i=0,j=1;
    String a;
    for(int lastNoZeroIndex=0,cur=0;cur<nums.length;cur++){
      if(nums[cur]!=0){
        swap(lastNoZeroIndex++,cur,nums);
      }
    }
//    while(i<nums.length && j<nums.length){
//    if(nums[i]==0){
//      //stop
//      if(nums[j]!=0){
//        swap(i++,j++,nums);
//
//      }else {
//        j++;
//      }
//    }else {
//      i++;
//      j++;
//    }
//
//    }
  }

  public static void main(String[]args){
    moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
  }
}
