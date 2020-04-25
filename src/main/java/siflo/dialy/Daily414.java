package siflo.dialy;

import java.util.Arrays;

/**
 *
 Daily Coding Problem
 Good morning! Here's your coding interview problem for today.

 This problem was asked by Uber.

 Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

 For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

 Follow-up: what if you can't use division?
 */
public class Daily414 {
 public static int[] product(int[] src){
   int[] left = new int[src.length];
   int[] right  = new int[src.length];
   //
   left[0] = 1;
   right[right.length-1] = 1;

   for(int i = 1;i<left.length;i++){
     left[i] = left[i-1]*src[i-1];
   }

   for(int i=right.length-2; i>=0;i--){
     right[i] = right[i+1]*src[i+1];
   }
   for(int i=0;i<src.length;i++){
     src[i] = left[i]*right[i];
   }
   return src;
 }

  public static void main(String[] args) {
    int[] input = {1,2,3,4,5};
    
    Arrays.stream(product(input)).forEach(i->System.out.println(i));
  }
}
