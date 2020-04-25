package siflo.arrays;

import java.util.Arrays;

/**
 * 要点是让指针i从 1 开始 ， 还有一个指针differentCounter，指向元素的位置。
 *   for(i=1;i<l;i++)
 *    if(a[i]!=a[i-1])
 *      //difference
 *      differentCounter++
 *      a[differentCounter] = a[i]
 *
 */
public class Exec21 {
  public int removeDuplicates(int[] nums) {
    if(nums==null || nums.length==0)
      return 0;
    int differCounter = 0;
    for(int i=1;i<nums.length;i++){
      if(nums[i]!=nums[i-1]) {
        differCounter++;
        nums[differCounter]=nums[i];
      }
    }

    return differCounter+1;
  }

  public static void main(String[] args)throws Exception{
    int[] nums = new int[]{123,321,22,33,33,44,45,55,55};
    int len = new Exec21().removeDuplicates(nums);
    for(int i=0;i<len;i++){
      System.out.println(nums[i]);
    }
  }
}
