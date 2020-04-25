package siflo.arrays;

import java.util.HashMap;
import java.util.Map;

public class Exec24 {

  public boolean containsDuplicate(int[] nums) {

    if(nums==null||nums.length==0)
      return false;
    Map<Integer,Boolean> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
      if(map.containsKey(nums[i]))
        return true;
      else
        map.put(nums[i],true);

    }
    return false;
  }


  public static void main(String[]args){
    int[] nums = {1,2,3,1};
    System.out.println(new Exec24().containsDuplicate(nums));
  }
}
