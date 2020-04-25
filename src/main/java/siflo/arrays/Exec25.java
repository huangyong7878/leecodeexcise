package siflo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exec25 {

  public static int findSingleInt(int[] nums){
    int ans = nums[0];
    if (nums.length > 1) {
      for (int i = 1; i < nums.length; i++) {
        ans = ans ^ nums[i];
      }
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {1,1,1,1,4};
    System.out.println(findSingleInt(nums));
  }
}
