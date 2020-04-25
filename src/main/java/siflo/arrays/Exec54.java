package siflo.arrays;

/**
 * 爬台阶问题
 */
public class Exec54 {

  /**
   * 递归 t(n) = o(2^n)
   * @param n
   * @return
   */
  int recursive(int n){
    if(n==1)
      return 1;
    if(n==2)
      return 2;
    return recursive(n-1)+recursive(n-2);
  }

  /**
   * memroize
   * t(n) = o(2n) = O(n)
   * @param n
   * @param a
   * @return
   */
  int mm(int n,int[]a){
    if(n==1)
      return 1;
    if(n==2)
      return 2;
    if(a[n]==0)
      a[n] = mm(n-1,a)+mm(n-2,a);

    return a[n];
  }
  int meroize(int n){
    int[] a = new int[n+1];
    return mm(n,a);
  }

  int bootup(int n){
    if(n==1)
      return 1;
    if(n==2)
      return 2;
    int[] bp = new int[n+1];
    bp[1] = 1;
    bp[2] = 2;
    for(int i=3;i<=n;i++){
      bp[i] += bp[i-1]+bp[i-2];
    }
    return bp[n];
  }


}
