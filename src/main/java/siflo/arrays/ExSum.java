package siflo.arrays;

import java.util.HashMap;
import java.util.Map;

public class ExSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int index = 0; index < nums.length; index++) {
      int complement = target - nums[index];
      int nextIndex = 0;
      if (map.containsKey(complement) && (nextIndex = map.get(complement)) != index) {
        return new int[]{index, nextIndex};
      }
    }
//    Long.valueOf(new String("")).longValue()<-Integer.MAX_VALUE

    return null;
  }

  public static int convert(int x){

    int rev= 0;
    while(x!=0){
      int pop = x%10;
      x/=10;
      if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
        rev = 0;
        break;
      }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
        rev = 0;
        break;
      }
      rev=rev*10+pop;
    }
    return rev;
  }

  public int reverse(int x) {

    char[] a = String.valueOf(x).toCharArray();
    int head = 0, tail = a.length-1;
    while(head<=tail){
      if(a[head]=='-')
        head++;
      else{
        char t = a[head];
        a[head] = a[tail];
        a[tail] = t;
        tail--;
        head++;
      }

    }

    long sa =  Long.valueOf(new String(a)).longValue();
    if(sa>0x7fffffff || sa<0x80000000)
      return 0;
    return Integer.valueOf(new String(a));

  }
  public static void main(String[] args) {
    System.out.println(convert(123));
  }
}
