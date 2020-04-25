package siflo.dialy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Daily425 {
  public static String longestKDistCharsSlipWindows(String a,int k){
    if(a==null || a.length()==0)
      return "";
    char[] cs = a.toCharArray();
    int l,r;
    String subStr = "";
    int d=0;
    int max = 0;
    Map<Character,Integer> distinctChars = new HashMap<>();
    for(l=0,r=0;l<cs.length&&r<cs.length;r++){
      if(!distinctChars.containsKey(cs[r]))
        d++;
     Integer dcc =  distinctChars.get(cs[r])  ;
     if(dcc == null)
       distinctChars.put(cs[r],1);
     else
       distinctChars.put(cs[r],dcc+1);
     while(d>k){
       int dcc1 =  distinctChars.get(cs[l])  ;
       distinctChars.put(cs[l],dcc1-1);
       if(distinctChars.get(cs[l])==0)
         d--;
       l++;
     }
     if(r-l+1>max){
       subStr = String.valueOf(cs,l,r-l+1);
     }
     max = Math.max(max,r-l+1);


    }
    return subStr;
  }
  public static String longestKeDistctChars(String a,int k){
    if(a==null || a.length()==0)
      return "";
    char[] chars = a.toCharArray();
    String subStr = "";
    int i=0,j=0;
    for( i=0;i<chars.length;i++){
      Set<Character> distinctChars = new HashSet<>();
      distinctChars.add(chars[i]);
     for( j=i+1;j<chars.length;j++) {
       if (distinctChars.size() < k) {
         distinctChars.add(chars[j]);
       } else {
         if (!distinctChars.contains(chars[j])) {
          break;
         }
       }
     }
      int l = j - i;
      if (l > subStr.length()) {
        subStr = String.valueOf(chars, i, l);
      }

    }
    return subStr;
  }

  public static void main(String[] args) {
    System.out.println(longestKDistCharsSlipWindows("abcade",3));
  }
}
