package siflo.dialy;

/**
 * https://www.youtube.com/watch?v=qli-JCrSwuk
 */
public class FacebookDecodMessage {
  static int helper(char[] data,int k){
    if(k==0)
      return 1;
    int s = data.length-k;
    if(data[s]=='0')
      return 0;
    int result = helper(data,k-1);
    if(k>=2 && new String(data,s,2).compareTo("26")<0)
      result += helper(data,k-2);
    return result;
  }
  static int numsOfWays(String data){
    return helper(data.toCharArray(),data.length());
  }

  public static void main(String[] args) {
   System.out.println( numsOfWays("123"));
  }
}
