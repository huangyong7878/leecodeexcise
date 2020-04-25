package siflo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exec26 {

//  public int[] intersect(int[] nums1, int[] nums2) {
//    HashMap<Integer,> results1 = new HashMap();
//    List<Integer> results2 = new ArrayList<>();
//    for(int i=0;i<nums1.length;i++)
//      results1.add(nums1[i]);
//    for(int i=0;i<nums2.length;i++){
//      int a = nums2[i];
//
//      if(results1.contains(a)){
//        results2.add(a);
//        results1.remove(a);
//      }
//    }
//    return results2.stream().mapToInt(ii->ii).toArray();
//
//  }
  public static int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> set = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        set.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      }
    }
    int[] res = new int[set.size()];
    int index = 0;
    for (int num : set) {
      res[index++] = num;
    }

    return res;
  }

  public static int[] intersec1(int[] nums1,int[] nums2){
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> r = new ArrayList<>();
    int i=0,j=0,k=0;
    while(i<nums1.length && j<nums2.length){
      if(nums1[i]==nums2[j]){
        nums1[k++]=nums1[i];
        i++;j++;
      }else if(nums1[i]>nums2[j])
        j++;
      else
        i++;
    }

    return Arrays.copyOfRange(nums1,0,k);
  }
  public static void main(String[] args){
    int[] num1 = {1,2,2,3};
    int[] num2 = {2,2};
    Arrays.stream(intersection(num1, num2)).forEach(a->System.out.println(a));
  }
}
