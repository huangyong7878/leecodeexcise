package siflo.arrays;

import java.util.Arrays;

public class Exec27 {
  public int[] plusOne(int[] digits) {
    int l = digits.length;
    int r = 0,plus=0;

    for(int i=l-1;i>=0;i--){
      r = digits[i]+r;
      if(i==l-1)
        r =r+1;
      if(r>=10){
        digits[i] = r-10;
        r = 1;
      }else{
        digits[i]=r;
        return digits;
      }

    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;

  }

  public static int[] plusOne1(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

public static void main(String[] args){
  Arrays.stream(plusOne1(new int[]{9,9,9})).forEach(a->System.out.println(a));
}
}
