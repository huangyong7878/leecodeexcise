package siflo.dialy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Daily425 {
  public static String longestKeDistctChars(String a,int k){

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
    System.out.println(longestKeDistctChars("abadcba",2));
  }
}
