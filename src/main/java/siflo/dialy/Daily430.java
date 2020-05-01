package siflo.dialy;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.<BR>
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:<BR>
 *
 * 10 = max(10, 5, 2)<BR>
 * 7 = max(5, 2, 7)<BR>
 * 8 = max(2, 7, 8)<BR>
 * 8 = max(7, 8, 7)<BR>
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
public class Daily430 {
  static void solution(int[] a,int  k){
    int max = Integer.MIN_VALUE;
    int l=0,r=0;
    int d = 0;
    int max1 = Integer.MIN_VALUE;
    for(;r<a.length;r++){
      max=Math.max(a[r],max);
      if(r>0)
        max1 = Math.max(a[r],max1);
      d++;
      if(d==k) {
        System.out.println(max);
        max = Integer.MIN_VALUE;
        l++;
        for(int z=l;z<=r;z++)
          max = Math.max(a[z],max);
        d--;
      }


    }
  }
  public static void main(String[] args) {
    int[] a = {10,3,21,7,9,12};
    solution(a,3);

  }
}
