package siflo.dialy;

import java.util.Arrays;
import org.junit.Assert;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant
 * space. In other words, find the lowest positive integer that does not exist in the array. The
 * array can contain duplicates and negative numbers as well.<BR>
 * <BR>
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class Daily416 {

  static int getMissingPositiveInt(int[] a) {

    int mpi = 1;
    int max = 1;
    for (int i : a) {
      if (i > 0) {
        mpi = Math.min(i,mpi);
        max = Math.max(i,max);
      }
    }
    for(int i:a){
      if(i==mpi)
        mpi= i+1;
    }
    if(mpi==max)
      mpi =  max+1;
    System.out.println(mpi);
    return mpi;
  }


  public static void main(String[] args) {
    int[] a1= {3,4-1,2};
    Assert.assertTrue( getMissingPositiveInt(a1)==1);
    int[] a2= {1,2,4};
    Assert.assertTrue(getMissingPositiveInt(a2)==3);
    int[] a3= {-3,-2,1,2,5,6,2,4};
    Assert.assertTrue(getMissingPositiveInt(a2)==3);
    int[] a4= {5,2,3,4,1};
    Assert.assertTrue(getMissingPositiveInt(a4)==6);
  }
}
